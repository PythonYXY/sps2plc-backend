package sps2plc.projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sps2plc.projects.dao.ProjectMapper;
import sps2plc.users.User;
import sps2plc.users.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectMapper projectMapper;
    private UserService userService;

    @Autowired
    public ProjectService(ProjectMapper projectMapper, UserService userService) {
        this.projectMapper = projectMapper;
        this.userService = userService;
    }

    public List<Project> getProjectsOfAuthUser() {
        User user = userService.getAuthenticatedUser();
        if (user == null) return new ArrayList<>();
        return projectMapper.findByUserId(user.getId());    }


    public Optional<Project> getProjectOfAuthUser(Long id) {
        User user = userService.getAuthenticatedUser();
        if (user == null) return Optional.empty();
        Project project = projectMapper.findById(id);
        project = project.getUserId().equals(user.getId()) ? project : null;
        return Optional.ofNullable(project);
    }

    public Optional<Project> saveProject(Project project) {
        User user = userService.getAuthenticatedUser();
        if (user == null) return Optional.empty();
        project.setUserId(user.getId());
        if (projectMapper.save(project) == 1) {
            return Optional.of(project);
        }
        return Optional.empty();
    }

    public void deleteProject(Long id) {
        projectMapper.deleteById(id);
    }

}
