package sps2plc.ioTable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
public class IOMap {

    private Long id;
    private Long projectId;

    // 这里必须显示指定Json属性名称，否则开头的几个大写字母会被自动转换成小写（尽量避免首字母大写的命名法）
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
