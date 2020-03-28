package sps2plc.core.models.translators;

import sps2plc.core.models.sps.expressions.*;

import java.util.Map;

public class SPS2SMT implements ExpressionVisitor {

    private final Map<String, SMTPattern> patternMap = SMTPattern.loadPattern(SMTPattern.PATTERNS_FILE);

    @Override
    public void visitBooleanExpression(BooleanExpression expression, BooleanExpression.Operator operator) {

    }

    @Override
    public void visitNumberExpression(NumberExpression expression, BooleanExpression.Operator operator) {

    }

    @Override
    public void visitUnaryExpression(UnaryExpression expression, BooleanExpression.Operator operator) {

    }

    @Override
    public void visitVariableExpression(VariableExpression expression, BooleanExpression.Operator operator) {

    }
}
