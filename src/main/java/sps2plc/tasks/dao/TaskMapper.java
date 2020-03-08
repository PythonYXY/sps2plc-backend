package sps2plc.tasks.dao;


import org.apache.ibatis.annotations.*;
import sps2plc.tasks.Task;

@Mapper
public interface TaskMapper {

    @Select("select * from task where project_id = #{projectId}")
    @Results(id = "taskMapper", value = {
            @Result(id = true, column = "project_id", property = "projectId"),
            @Result(column = "code", property = "code"),
            @Result(column = "description", property = "description"),
            @Result(column = "requirements", property = "requirements"),
            @Result(column = "status", property = "status"),
            @Result(column = "timestamp", property = "timestamp")
    })
    Task findByProjectId(Long projectId);

    @Insert("insert into task (project_id, code, description, requirements, status, timestamp)" +
            "values (#{projectId}, #{code}, #{description}, #{requirements}, #{status}, #{timestamp})")
    @ResultMap("taskMapper")
    int save(Task task);
}
