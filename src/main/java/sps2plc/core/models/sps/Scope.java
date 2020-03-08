package sps2plc.core.models.sps;

import sps2plc.core.models.sps.expressions.Expression;

import java.util.List;
import java.util.stream.Collectors;

public class Scope {

    public enum Type {
        GLOBALLY,
        AFTER,
        AFTER_UNTIL,
        WHEN,
        INTERLOCK
    }

    private final Type type;

    private final List<Expression> expressions;

    public Scope(Type type, List<Expression> expressions) {
        this.type = type;
        this.expressions = expressions;
    }

    public Type getType() {
        return type;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }


    @Override
    public String toString() {
        return type.toString() + " " + expressions.stream().map(expr -> expr.toString()).collect(Collectors.joining(", "));
    }
}
