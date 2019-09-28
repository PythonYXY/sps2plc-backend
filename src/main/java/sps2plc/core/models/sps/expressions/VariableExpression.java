package sps2plc.core.models.sps.expressions;

import java.util.ArrayList;
import java.util.List;

public class VariableExpression extends Expression {

    private String name;

    public VariableExpression(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public void accept(ExpressionVisitor visitor, BooleanExpression.Operator operator) { visitor.visitVariableExpression(this, operator); }

    @Override
    public String toString() { return name; }

    @Override
    public Expression negateExpression() {
        return new UnaryExpression(new VariableExpression(name), UnaryExpression.Operator.NOT);
    }

    @Override
    public void replaceVariableExpression(String oldVar, String newVar) {
        if (name.equals(oldVar)) name = newVar;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<String>() {{ add(name); }};
    }

}
