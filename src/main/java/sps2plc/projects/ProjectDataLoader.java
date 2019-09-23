package sps2plc.projects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Order(1)
public class ProjectDataLoader implements CommandLineRunner {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectDataLoader(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Preloading " + this.projectRepository.save(new Project("电动机单相全波整流能耗制动控制", "")));
        log.info("Preloading " + this.projectRepository.save(new Project("故障报警控制系统", "")));
        log.info("Preloading " + this.projectRepository.save(new Project("M7475型立轴圆台平面磨床控制", "")));
        log.info("Preloading " + this.projectRepository.save(new Project("project-4", "")));
    }
}