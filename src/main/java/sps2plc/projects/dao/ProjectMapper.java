package sps2plc.projects.dao;


import org.apache.ibatis.annotations.*;
import sps2plc.projects.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select * from project where userId = #{userId}")
    List<Project> findByUserId(Long userId);

    @Select("select * from project where id = #{id}")
    Project findById(Long id);

    @Insert("insert into project (description, name) values (#{description}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Project project);

    @Delete("delete from project where id = #{id}")
    int deleteById(Long id);
}
