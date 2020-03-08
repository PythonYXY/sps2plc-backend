package sps2plc.requirements.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import sps2plc.requirements.Requirement;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class RequirementMapperTest {

    @Autowired
    private RequirementMapper requirementMapper;

    @Test
    public void testFindByProjectOrderById() {
        requirementMapper.findByProjectOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        System.out.println(requirementMapper.findById(1L));
    }

    @Test
    public void testFindByProjectAndDisabledOrderById() {
        requirementMapper.findByProjectAndDisabledOrderById(1L, false).forEach(System.out::println);
    }

    @Test
    public void testSave() {
        Requirement requirement = new Requirement("text",
                1L,
                "errorDescription",
                Requirement.ReqState.COMPLIANT,
                false);
        System.out.println(requirementMapper.save(requirement));
        requirementMapper.findByProjectOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testUpdateRequirement() {
        Requirement requirement = new Requirement("text",
                1L,
                "errorDescription",
                Requirement.ReqState.COMPLIANT,
                false);
        requirement.setId(1L);
        System.out.println(requirementMapper.updateRequirement(requirement));
        requirementMapper.findByProjectOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        System.out.println(requirementMapper.deleteById(1L));
        requirementMapper.findByProjectOrderById(1L).forEach(System.out::println);
    }
}
