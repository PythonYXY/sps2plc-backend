package sps2plc.requirements;

public class FailedToCreateRequirementException extends RuntimeException {
    public FailedToCreateRequirementException(Requirement requirement) {
        super("could not create requirement: " + requirement);
    }
}
