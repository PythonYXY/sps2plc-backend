package sps2plc.core.models.sps.expressions;

import java.util.List;

public class UnaryExpression extends Expression {

    public enum Operator {
        NOT("not");

        private final String op;

        Operator(String op) { this.op = op; }

        @Override
        public String toString() { return op; }
    }

    private Expression expr;

    private Operator operator;

    public UnaryExpression(Expression expr, Operator operator) {
        this.expr = expr;
        this.operator = operator;
    }

    public Expression getExpr() {
        return expr;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public void accept(ExpressionVisitor visitor, BooleanExpression.Operator operator) { visitor.visitUnaryExpression(this, operator); }

    public static Operator getOperator(String operator) {
        for (Operator op: Operator.values()) {
            if (op.toString().equals(operator)) return op;
        }

        throw new IllegalArgumentException("UnaryOperator: " + operator + " not found.");
    }

    @Override
    public Expression negateExpression() {
        if (expr instanceof VariableExpression | expr instanceof NumberExpression | expr instanceof UnaryExpression) {
            return expr;
        } else if (expr instanceof BooleanExpression) {
            return expr.negateExpression();
        } else {
            throw new RuntimeException("Unknown expression type.");
        }

    }

    @Override
    public List<String> getVariables() {
        return expr.getVariables();
    }

    @Override
    public String toString() {
        return operator + " " + expr.toString();
    }

}
