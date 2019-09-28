package sps2plc.core.models.sps.expressions;

import java.util.List;

abstract public class Expression {

    /**
     * Accept
     *
     * @param visitor the visitor
     */
    public abstract void accept(ExpressionVisitor visitor, BooleanExpression.Operator operator);

    public abstract Expression negateExpression();

    public abstract List<String> getVariables();

    public abstract void replaceVariableExpression(String oldVar, String newVar);
}
