package sps2plc.core.models.sps;


import sps2plc.core.models.sps.expressions.Expression;
import sps2plc.core.models.sps.expressions.VariableExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Requirement {

    /** The requirement ID. **/
    private String reqId;

    /** The requirement text. **/
    private String text;

    private final Scope scope;

    private final Delay delay;

    /** List of properties with the same scope. **/
    private final Property property;

    /**
     * Instantiates a non-realtime requirement.
     *
     * @param scope the scope
     * @param property the property
     */
    public Requirement(Scope scope, Property property) {
        this(scope, null, property);
    }

    public Requirement(Scope scope, Delay deley, Property property) {
        if (scope == null) {
            this.scope = new Scope(Scope.Type.GLOBALLY, Collections.emptyList());
        } else {
            this.scope = scope;
        }

        this.delay = deley;
        this.property = property;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Scope getScope() {
        return scope;
    }

    public Delay getDelay() {
        return delay;
    }

    public Property getProperty() { return property; }

    public String getTarget() {
        try {
            return getProperty().getExpression().getVariables().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("requirement does not have controlled target.");
        }
    }

    public void setTarget(String target) {
        getProperty().setExpression(target);
    }

    public boolean isDependsOn(Requirement requirement) {
        String target = ((VariableExpression)requirement.getProperty().getExpression()).getName();

        for (Expression expr: getScope().getExpressions()) {
            for (String var: expr.getVariables()) {
                if (var.equals(target)) return true;
            }
        }
        return false;
    }

    public String key() {

        return scope.getType() + "." + (delay == null ? "null" : delay.getType());
    }

    @Override
    public String toString() {
        return scope.toString() + "; " + (delay != null ? (delay.toString() + "; ") : "") + property.toString();
    }
}
