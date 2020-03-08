package sps2plc.users.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import sps2plc.users.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findUserByUsername(String username);

    @Select("select * from user where id = #{id}")
    User findUserById(Long id);

    @Insert("insert into user (username, password) values (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);
}
