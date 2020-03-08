package sps2plc.core.models.sps;

import sps2plc.core.models.sps.expressions.Expression;
import sps2plc.core.models.sps.expressions.VariableExpression;

public class Property {

    public enum Type {
        UNIVERSALITY,
        ABSENCE,
        EXISTENCE,
        INTERLOCK
    }

    private final Type type;

    private Expression expression;

    public Property(Type type, Expression expression) {
        this.type = type;
        this.expression = expression;
    }

    public Type getType() {
        return type;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(String target) {
        if (type == Type.INTERLOCK) throw new RuntimeException("set expression to INTERLOCK property.");
        expression = new VariableExpression(target);
    }

    @Override
    public String toString() {
        return type + ", " + expression;
    }
}
