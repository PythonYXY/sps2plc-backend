package sps2plc.ioTable.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import sps2plc.ioTable.IOMap;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class IOTableMapperTest {

    @Autowired
    private IOTableMapper ioTableMapper;

    @Test
    public void testFindByProjectIdOrderById() {
        ioTableMapper.findByProjectIdOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        System.out.println(ioTableMapper.findById(100L));
    }

    @Test
    public void testSave() {
        IOMap ioMap = new IOMap(1L, "name", "number");
        System.out.println(ioTableMapper.save(ioMap));
        System.out.println(ioMap);
        ioTableMapper.findByProjectIdOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        IOMap ioMap = new IOMap(1L, "name", "number");
        ioMap.setId(1L);
        System.out.println(ioTableMapper.update(ioMap));
        ioTableMapper.findByProjectIdOrderById(1L).forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        System.out.println(ioTableMapper.deleteById(1L));
        ioTableMapper.findByProjectIdOrderById(1L).forEach(System.out::println);
    }
}
