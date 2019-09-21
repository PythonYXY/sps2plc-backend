package sps2plc.core.models.sps;

public interface DelayVisitor {

    void visitWithEndType1Delay(Delay delay);

    void visitWithEndType2Delay(Delay delay);

    void visitWithOutEndDelay(Delay delay);

    void visitOnBothSidesType1Delay(Delay delay);

    void visitOnBothSidesType2Delay(Delay delay);

    void visitOnBothSidesType3Delay(Delay delay);
}
