package sps2plc.requirements;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Requirement {

    public enum ReqState {
        COMPLIANT,
        ERROR,
    }

    private @Id @GeneratedValue Long id;
    private @NotNull String text;
    private @NotNull Long project;
    private String errorDescription;
    private @NotNull @Enumerated(EnumType.STRING) ReqState state;
    private @NotNull Boolean disabled;


    public Requirement() {

    }

    public Requirement(String text, Long project, String errorDescription, ReqState state, Boolean disabled) {
        this.text = text;
        this.project = project;
        this.errorDescription = errorDescription;
        this.state = state;
        this.disabled = disabled;
    }


}
