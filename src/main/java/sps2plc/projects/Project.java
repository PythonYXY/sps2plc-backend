package sps2plc.projects;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Project {

    private @Id @GeneratedValue Long id;
    private @NotNull String name;
    private String description;

    public Project() {

    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
