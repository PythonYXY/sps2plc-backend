package sps2plc.projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Retrieve all projects in the database
     * @return projects list
     */
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }


    /**
     * Retrieve project with given id, if it does not exist, return error message with http status code 404.
     * @param id
     * @return project or err msg
     */
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
