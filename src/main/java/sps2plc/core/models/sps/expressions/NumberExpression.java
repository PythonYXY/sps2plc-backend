package sps2plc.core.models.sps.expressions;

import java.util.List;

public class NumberExpression extends Expression {

    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public void accept(ExpressionVisitor visitor, BooleanExpression.Operator operator) { visitor.visitNumberExpression(this, operator); }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Expression negateExpression() {
        return new UnaryExpression(new NumberExpression(value), UnaryExpression.Operator.NOT);
    }

    @Override
    public List<String> getVariables() {
        throw new RuntimeException("Number expression does not have variables!");
    }

    @Override
    public void replaceVariableExpression(String oldVar, String newVar) { throw new RuntimeException("Number expression does not have variables!"); }
}
