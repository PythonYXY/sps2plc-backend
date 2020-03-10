package sps2plc.requirements;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
public class Requirement {

    public enum ReqState {
        COMPLIANT,
        ERROR,
        NOT_CHECKED
    }

    private Long id;
    private String text;
    private Long project;
    private String description;
    private String errorDescription;
    private ReqState state;
    private Boolean disabled;

    public Requirement() {

    }

    public Requirement(String text, Long project, String description, String errorDescription, ReqState state, Boolean disabled) {
        this.text = text;
        this.project = project;
        this.description = description;
        this.errorDescription = errorDescription;
        this.state = state;
        this.disabled = disabled;
    }


}
