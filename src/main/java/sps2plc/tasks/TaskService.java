package sps2plc.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sps2plc.ioTable.IOMap;
import sps2plc.ioTable.IOTableService;
import sps2plc.requirements.Requirement;
import sps2plc.requirements.RequirementService;
import sps2plc.core.SpsToPlc_final;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<String> getPriorityId(String ret) {
        return Arrays.asList(ret.substring(10).split("\r\n"))
                .stream()
                .map(str -> Arrays.asList(str.split("<")).stream()
                        .map(index -> Long.toString(this.reqArray.get(Integer.parseInt(index) - 1).getId()))
                        .collect(Collectors.joining("<"))
                )
                .collect(Collectors.toList());
    }

    public Task getTask(Long projId) {
        this.reqArray = this.requirementService.getProjectRequirementsEnabled(projId);
        List<IOMap> ioTable = this.ioTableService.getProjectIOTable(projId);
        Map<String, String> ioMap = new HashMap<>();
        for (IOMap io: ioTable) {
            ioMap.put(io.getIOName(), io.getIONumber());
        }

        String priority = "";
        String pattern = "[\\u4E00-\\u9FA5]\\S+[\\u4E00-\\u9FA5]";
        Pattern r = Pattern.compile(pattern);

        String ret = SpsToPlc_final.specAnlysis(
                this.reqArray.stream()
                        .map(requirement -> {
                            String temp = requirement.getText();
                            Matcher m = r.matcher(requirement.getText());
                            while (m.find()) {
//                                System.out.println("temp: " + temp + ", mGroup(0): " + m.group(0));
                                String repStr = ioMap.containsKey(m.group(0)) ? ioMap.get(m.group(0)) : m.group(0);
                                temp = temp.replace(m.group(0), repStr);
                            }
                            System.out.println(temp);
                            return temp;
                        })
                        .collect(Collectors.toList()),
                priority);

        if (ret.startsWith("code")) {
            SpsToPlc_final.reset();
            return taskRepository.save(new Task(
                    projId,
                    "Generated PLC Code",
                    Task.TaskStatus.GENERATE,
                    null,
                    ret.substring(6)
            ));
        }

        return new Task(
                projId,
                "Claim priority of following specifications with the same object: ",
                Task.TaskStatus.PRIORITY,
                getPriorityId(ret),
                null
        );
    }

    public List<String> getPriorityIndex(List<String> priorityArray) {
        return priorityArray.stream()
                .map(str -> Arrays.asList(str.split("<"))
                        .stream()
                        .map(id -> {
                            for (int i = 0; i < this.reqArray.size(); i++) {
                                if (this.reqArray.get(i).getId() == Long.parseLong(id)) return Integer.toString(i + 1);
                            }
                            return id;
                        }
                        )
                        .collect(Collectors.joining("<"))
                )
                .collect(Collectors.toList());
    }

    public Task getTask(Task task) {
        String priority = getPriorityIndex(task.getPriorityArray()).stream()
                .collect(Collectors.joining("\r\n","", "\r\n"));

        List<IOMap> ioTable = this.ioTableService.getProjectIOTable(task.getProjectId());
        Map<String, String> ioMap = new HashMap<>();
        for (IOMap io: ioTable) {
            ioMap.put(io.getIOName(), io.getIONumber());
        }

        String pattern = "[\\u4E00-\\u9FA5]\\S+[\\u4E00-\\u9FA5]";
        Pattern r = Pattern.compile(pattern);

        String ret = SpsToPlc_final.specAnlysis(
                this.reqArray.stream()
                        .map(requirement -> {
                            String temp = requirement.getText();
                            Matcher m = r.matcher(requirement.getText());
                            while (m.find()) {
//                                System.out.println("temp: " + temp + ", mGroup(0): " + m.group(0));
                                String repStr = ioMap.containsKey(m.group(0)) ? ioMap.get(m.group(0)) : m.group(0);
                                temp = temp.replace(m.group(0), repStr);
                            }
                            System.out.println(temp);
                            return temp;
                        })
                        .collect(Collectors.toList()),
                priority);
        SpsToPlc_final.reset();

        return taskRepository.save(new Task(
                task.getProjectId(),
                "Generated PLC Code",
                Task.TaskStatus.GENERATE,
                null,
                ret.substring(6)
                )
        );
    }

    public Task getFinishedTask(Long projId) {
        return taskRepository.findById(projId).orElse(null);
    }

}
