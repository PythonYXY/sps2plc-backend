package sps2plc.ioTable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class IOMap {

    private @Id @GeneratedValue Long id;
    private @NotNull Long projectId;

    private @JsonProperty("IOName") String IOName;
    private @JsonProperty("IONumber") String IONumber;

    public IOMap() {

    }

    public IOMap(Long projectId, String IOName, String IONumber) {
        this.projectId = projectId;
        this.IOName = IOName;
        this.IONumber = IONumber;
    }


}
