package sps2plc.tasks;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Task {
    public enum TaskStatus {
        GENERATE,
        PRIORITY,
        CIRCULAR
    }

    private @Id  @NotNull Long projectId;
    private String description;
    private @Enumerated(EnumType.STRING) TaskStatus status;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "dd-MM-yyyy kk:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private @ElementCollection List<String> priorityArray;
    private @ElementCollection List<String> circularDependencyArray;

    @Column(columnDefinition = "TEXT")
    private String code;


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

}
