package sps2plc.projects.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import sps2plc.projects.Project;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class ProjectMapperTest {

    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void testFindAll() {
        projectMapper.findByUserId(1L).forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        System.out.println(projectMapper.findById(1L));
    }

    @Test
    public void testSave() {
        Project project = new Project("project", "description");
        System.out.println(projectMapper.save(project));
        System.out.println(project);
        projectMapper.findByUserId(1L).forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        System.out.println(projectMapper.deleteById(1L));
        projectMapper.findByUserId(1L).forEach(System.out::println);
    }
}
