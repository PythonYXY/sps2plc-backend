package sps2plc.tasks;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @MybatisTest will detect a class that annotated @SpringBootApplication by default.
 * Therefore by depend on bean definition methods, there is case that an unexpected error is occurred or unnecessary components are loaded into ApplicationContext.
 * This behavior can prevent by creating a @SpringBootApplication class into same package as test class.
 */
@SpringBootApplication
public class MapperTestApplication {

}
