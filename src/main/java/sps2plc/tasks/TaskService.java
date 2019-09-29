package sps2plc.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sps2plc.core.fe.SPSFrontEnd;
import sps2plc.core.models.plc.ILCode;
import sps2plc.ioTable.IOMap;
import sps2plc.ioTable.IOTableService;
import sps2plc.requirements.Requirement;
import sps2plc.requirements.RequirementService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class TaskService {

    private TaskRepository taskRepository;
    private RequirementService requirementService;
    private List<Requirement> reqArray;
    private IOTableService ioTableService;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       RequirementService requirementService,
                       IOTableService ioTableService) {
        this.taskRepository = taskRepository;
        this.requirementService = requirementService;
        this.ioTableService = ioTableService;
    }

    private String preprocessRequirement(Long projId, List<Requirement> reqArray) {
        List<IOMap> ioTable = this.ioTableService.getProjectIOTable(projId);
        Map<String, String> ioMap = new HashMap<>();
        for (IOMap io: ioTable) {
            ioMap.put(io.getIOName(), io.getIONumber());
        }

        String pattern = "[\\u4E00-\\u9FA5]\\S+[\\u4E00-\\u9FA5]";
        Pattern r = Pattern.compile(pattern);

        StringBuilder ret = new StringBuilder();
        reqArray.forEach(requirement -> {
            String temp = requirement.getText();
            Matcher m = r.matcher(requirement.getText());
            while (m.find()) {
//            System.out.println("temp: " + temp + ", mGroup(0): " + m.group(0));
                String repStr = ioMap.containsKey(m.group(0)) ? ioMap.get(m.group(0)) : m.group(0);
                temp = temp.replace(m.group(0), repStr);
            }
            System.out.println("[" + requirement.getId() + "]" + temp);

            ret.append('[' + String.valueOf(requirement.getId()) + ']' + temp + '\n');
        });
        return ret.toString();
    }

    public Task getTask(Long projId) {
        this.reqArray = this.requirementService.getProjectRequirementsEnabled(projId);
        ILCode ilCode;

        try {
            SPSFrontEnd fe = new SPSFrontEnd();
            fe.parseString(preprocessRequirement(projId, this.reqArray));
            ilCode = fe.getILCode(null);
        } catch (Exception err) {
            return new Task(
                    projId,
                    "Error",
                    Task.TaskStatus.GENERATE,
                    null,
                    null,
                    err.toString()
            );
        }

        if (!ilCode.getCircularDependencyRequirements().isEmpty()) {
            return new Task(
                    projId,
                    "There is a circular dependency among the following requirements:",
                    Task.TaskStatus.CIRCULAR,
                    null,
                    ilCode.getCircularDependencyRequirements().stream().map(reqIds -> String.join(",", reqIds)).collect(Collectors.toList()),
                    null
            );
        }

        List<String> priorities = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: ilCode.getConflictedRequirements().entrySet()) {
            priorities.add(String.join("<", entry.getValue()));
        }

        if (!ilCode.getConflictedRequirements().isEmpty()) {
            return new Task(
                    projId,
                    "Claim priority of following specifications with the same object: ",
                    Task.TaskStatus.PRIORITY,
                    priorities,
                    null,
                    null
            );
        }

        return taskRepository.save(new Task(
                projId,
                "Generated IL Code",
                Task.TaskStatus.GENERATE,
                null,
                null,
                ilCode.getGeneratedILCode()
        ));
    }


    public Task getTask(Task task) {
        this.reqArray = this.requirementService.getProjectRequirementsEnabled(task.getProjectId());

        List<List<String>> priorityArray = new ArrayList<>();
        final StringBuilder priorities = new StringBuilder("Priorities:\n");
        task.getPriorityArray().forEach(priority -> {
            priorities.append(priority).append("\n");
            priorityArray.add(Arrays.asList(priority.split("<")));
        });
        priorities.append("\n\n");
        String requirements = preprocessRequirement(task.getProjectId(), reqArray);

        ILCode ilCode;
        try {
            SPSFrontEnd fe = new SPSFrontEnd();
            fe.parseString(requirements);
            ilCode = fe.getILCode(priorityArray);
        } catch (Exception err) {
            return new Task(
                    task.getProjectId(),
                    "Error",
                    Task.TaskStatus.GENERATE,
                    null,
                    null,
                    err.toString(),
                    ""
            );
        }

        return taskRepository.save(new Task(
                task.getProjectId(),
                "Generated IL Code",
                Task.TaskStatus.GENERATE,
                null,
                null,
                ilCode.getGeneratedILCode(),
                priorities.toString() + requirements
                )
        );
    }

    public Task getFinishedTask(Long projId) {
        return taskRepository.findById(projId).orElse(null);
    }

}
