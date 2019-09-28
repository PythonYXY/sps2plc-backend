package sps2plc.core.models.sps.expressions;

import java.util.ArrayList;
import java.util.List;

public class BooleanExpression extends Expression{

    public enum Operator {
        AND("and"),
        OR("or");

        private final String op;

        Operator(String op) { this.op = op; }

        @Override
        public String toString() { return op; }
    }

    private Expression leftExpr, rightExpr;

    private Operator operator;

    @Override
    public void accept(ExpressionVisitor visitor, BooleanExpression.Operator operator) { visitor.visitBooleanExpression(this, operator); }

    public BooleanExpression(Expression leftExpr, Expression rightExpr, Operator operator) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
        this.operator = operator;
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }

    public Operator getOperator() {
        return operator;
    }

    public static Operator getOperator(String operator) {
        for (Operator op: Operator.values()) {
            if (op.toString().equals(operator)) return op;
        }
        throw new IllegalArgumentException("BinaryOperator: " + operator + " not found.");
    }

    @Override
    public Expression negateExpression() {
        Operator op = operator == Operator.AND ? Operator.OR : Operator.AND;
        return new BooleanExpression(leftExpr.negateExpression(), rightExpr.negateExpression(), op);
    }

    @Override
    public List<String> getVariables() {
        List<String> ret = new ArrayList<>();
        ret.addAll(leftExpr.getVariables());
        ret.addAll(rightExpr.getVariables());
        return ret;
    }

    @Override
    public void replaceVariableExpression(String oldVar, String newVar) {
        leftExpr.replaceVariableExpression(oldVar, newVar);
        rightExpr.replaceVariableExpression(oldVar, newVar);
    }

    @Override
    public String toString() {
        return "(" + leftExpr.toString() + " " + operator + " " + rightExpr.toString() + ")";
    }
}
