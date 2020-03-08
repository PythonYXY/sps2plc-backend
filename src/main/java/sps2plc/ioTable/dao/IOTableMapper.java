package sps2plc.ioTable.dao;

import org.apache.ibatis.annotations.*;
import sps2plc.ioTable.IOMap;

import java.util.List;

@Mapper
public interface IOTableMapper {

    @Select("select * from iomap where project_id = #{projectId}")
    @Results(id = "ioTableMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "io_name", property = "IOName"),
            @Result(column = "io_number", property = "IONumber"),
            @Result(column = "project_id", property = "projectId")
    })
    List<IOMap> findByProjectIdOrderById(Long projectId);

    @Select("select * from iomap where id = #{id}")
    @ResultMap("ioTableMapper")
    IOMap findById(Long id);

    @Insert("insert into iomap (io_name, io_number, project_id) values (#{IOName}, #{IONumber}, #{projectId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(IOMap ioMap);

    @Update("update iomap set io_name = #{IOName}, io_number = #{IONumber}, project_id = #{projectId} where id = #{id}")
    int update(IOMap ioMap);

    @Delete("delete from iomap where id = #{id}")
    int deleteById(Long id);
}
