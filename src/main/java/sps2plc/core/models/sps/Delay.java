package sps2plc.core.models.sps;

import sps2plc.core.models.sps.expressions.Expression;

import java.util.List;
import java.util.stream.Collectors;

public class Delay {

    public enum Type {
        WITHEND_TYPE2, // delayL = 0, delayR != 0
        WITHEND_TYPE1, // delayL != 0, delayR != 0
        WITHOUTEND,
        ONRIGHTSIDE, // delayL = 0, delayRE != 0
        ONBOTHSIDES, // delayL != 0, delayRE != 0
    }

    public final Type type;

    public final List<Expression> expressions;

    public Delay(Type type, List<Expression> expressions) {
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
        return type.toString() + ", " + expressions.stream().map(expr -> expr.toString()).collect(Collectors.joining(", "));
    }


}
