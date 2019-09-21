package sps2plc.projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    ProjectService projectService;
    ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> all() {
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public Project one(@PathVariable("id") Long id) {
        return projectService.getProject(id);
    }

    /**
     * curl -X POST localhost:8080/projects -H 'Content-type:application/json' -d '{"name": "project-3", "description": "nothing"}'
     */
    @PostMapping
    public ResponseEntity<?> newProject(@Valid @RequestBody Project project) {
        project = projectService.saveProject(project);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        return projectRepository.findById(id)
                .map(project -> {
                    projectService.deleteProject(id);
                    return new ResponseEntity<>(project, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
