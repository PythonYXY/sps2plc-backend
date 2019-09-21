package sps2plc.projects;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Could not found project: " + id);
    }
}
