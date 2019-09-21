package sps2plc.tasks;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long projId) {
        super("Could not found task of project: " + projId);
    }
}
