package sps2plc.projects;


import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class Project {

    private Long id;
    private String name;
    private String description;
    private Long userId;

    public Project() {

    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description, Long userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }
}
