package sps2plc.requirements;

public class RequirementNotFoundException extends RuntimeException {
    public RequirementNotFoundException(Long id) {
        super("Could not found requirement: " + id);
    }
}
