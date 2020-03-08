package sps2plc.tasks;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class Task {
    public enum TaskStatus {
        GENERATE,
        PRIORITY,
        CIRCULAR
    }

    private Long projectId;
    private String description;
    private TaskStatus status;

    private Date timestamp;

    private List<String> priorityArray;
    private List<String> circularDependencyArray;

    private String code;
    private String requirements;


    public Task() {

    }

    public Task(@NotNull Long projectId, String description, TaskStatus status, Date timestamp, List<String> priorityArray, List<String> circularDependencyArray, String code) {
        this.projectId = projectId;
        this.description = description;
        this.status = status;
        this.timestamp = timestamp;
        this.priorityArray = priorityArray;
        this.circularDependencyArray = circularDependencyArray;
        this.code = code;
    }

    public Task(Long projectId, String description, TaskStatus status,  List<String> priorityArray, List<String> circularDependencyArray, String code) {
        this.projectId = projectId;
        this.description = description;
        this.status = status;
        this.timestamp = new Date();
        this.priorityArray = priorityArray;
        this.circularDependencyArray = circularDependencyArray;
        this.code = code;
    }

    public Task(Long projectId, String description, TaskStatus status,  List<String> priorityArray, List<String> circularDependencyArray, String code, String requirements) {
        this.projectId = projectId;
        this.description = description;
        this.status = status;
        this.timestamp = new Date();
        this.priorityArray = priorityArray;
        this.circularDependencyArray = circularDependencyArray;
        this.code = code;
        this.requirements = requirements;
    }

}
