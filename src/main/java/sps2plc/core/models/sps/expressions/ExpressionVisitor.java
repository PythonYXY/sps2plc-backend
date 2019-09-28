package sps2plc.core.models.sps.expressions;

public interface ExpressionVisitor {

    void visitBooleanExpression(BooleanExpression expression, BooleanExpression.Operator operator);

    void visitNumberExpression(NumberExpression expression, BooleanExpression.Operator operator);

    void visitUnaryExpression(UnaryExpression expression, BooleanExpression.Operator operator);

    void visitVariableExpression(VariableExpression expression, BooleanExpression.Operator operator);
}
