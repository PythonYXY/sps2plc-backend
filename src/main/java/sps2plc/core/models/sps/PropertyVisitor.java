package sps2plc.core.models.sps;

public interface PropertyVisitor {

    void visitUniversalityProperty(Property property);

    void visitAbsenceProperty(Property property);

    void visitExistenceProperty(Property property);

    void visitInterlockProperty(Property property);
}
