package sps2plc.requirements.dao;

import org.apache.ibatis.annotations.*;
import sps2plc.requirements.Requirement;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Mapper
public interface RequirementMapper {

    @Select("select * from requirement where project = #{project} order by id")
    @Results(id = "requirementMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "disabled", property = "disabled"),
            @Result(column = "error_description", property = "errorDescription"),
            @Result(column = "project", property = "project"),
            @Result(column = "state", property = "state"),
            @Result(column = "text", property = "text")
    })
    List<Requirement> findByProjectOrderById(Long project);

    @Select("select * from requirement where id = #{id}")
    @ResultMap("requirementMapper")
    Requirement findById(Long id);

    @Select("select * from requirement where project = #{project} and disabled = #{disabled} order by id")
    @ResultMap("requirementMapper")
    List<Requirement> findByProjectAndDisabledOrderById(Long project, boolean disabled);

    @Insert("insert into requirement (disabled, error_description, project, state, text) " +
            "values (#{disabled}, #{errorDescription}, #{project}, #{state}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Requirement requirement);

    @Update("update requirement set disabled = #{disabled}, error_description = #{errorDescription}, project = #{project}, " +
            "state = #{state}, text = #{text} where id = #{id}")
    int updateRequirement(Requirement requirement);

    @Delete("delete from requirement where id = #{id}")
    int deleteById(Long id);
}
