package sps2plc.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import sps2plc.requirements.Requirement;
import sps2plc.requirements.dao.RequirementMapper;
import sps2plc.tasks.dao.TaskMapper;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testFindById() {
        System.out.println(taskMapper.findByProjectId(1L));
    }

    @Test
    public void testSave() {
        System.out.println(taskMapper.save(new Task(1L,
                "description",
                Task.TaskStatus.GENERATE,
                null,
                null,
                "code",
                "")));
        System.out.println(taskMapper.findByProjectId(1L));
    }
}
