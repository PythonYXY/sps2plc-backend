package sps2plc.core.fe.sps.parser;

import sps2plc.core.models.sps.Delay;
import sps2plc.core.models.sps.Property;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.sps.Scope;
import sps2plc.core.models.sps.expressions.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class RequirementBuilder extends RequirementGrammarBaseListener {

    private Context context = new Context();

    /** maps nodes to Expressions with Map<ParseTree, Expression>. **/
    private ParseTreeProperty<Object> values = new ParseTreeProperty<>();

    private String reqId = null;
    private Scope scope = null;
    private Delay delay = null;
    private Property property = null;

    public Context getContext() { return context; }

    @Override public void enterRequirement(RequirementGrammarParser.RequirementContext ctx) {
        reqId = null;
        scope = null;
        delay = null;
        property = null;
    }

    @Override public void exitRequirement(RequirementGrammarParser.RequirementContext ctx) {
        Requirement req = new Requirement(scope, delay, property);
        String text = ctx.start.getInputStream().getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));

        req.setReqId(reqId);
        req.setText(text);
        context.addRequirement(req);
    }

    @Override public void exitReqID(RequirementGrammarParser.ReqIDContext ctx) {
        reqId = ctx.number().getText();
    }

    @Override public void exitScope(RequirementGrammarParser.ScopeContext ctx) {
        List<Expression> expressions = getExpressionList(ctx.expr());
        Scope.Type type = null;
        switch (ctx.getChild(0).getText()) {
            case "Globally":
                type = Scope.Type.GLOBALLY;
                break;
            case "When":
                type = Scope.Type.WHEN;
                break;
            case "After":
                if (expressions.size() == 2)
                    type = Scope.Type.AFTER_UNTIL;
                else
                    type = Scope.Type.AFTER;
                break;
        }

        scope = new Scope(type, expressions);
    }


    @Override public void exitDelayWithEnd(RequirementGrammarParser.DelayWithEndContext ctx) {
        List<Expression> exprs = getExpressionList(ctx.expr());
        float delayL = ((NumberExpression)exprs.get(0)).getValue();
        float delayR = ((NumberExpression)exprs.get(1)).getValue();

        if (delayL == 0 && delayR != 0) {
            delay = new Delay(Delay.Type.WITHEND_TYPE1, exprs);
        } else if (delayL != 0 && delayR != 0) {
            delay = new Delay(Delay.Type.WITHEND_TYPE2, exprs);
        } else {
            throw new RuntimeException("Delay with end with wrong parameters: delayL=" + delayL + " , delayR=" + delayR);
        }
    }

    @Override public void exitDelayWithoutEnd(RequirementGrammarParser.DelayWithoutEndContext ctx) {
        delay = new Delay(Delay.Type.WITHOUTEND,  new ArrayList<Expression>(){{ add(getExpression(ctx.expr())); }});
    }

    @Override public void exitDelayOnBothSides(RequirementGrammarParser.DelayOnBothSidesContext ctx) {
        List<Expression> exprs = getExpressionList(ctx.expr());
        float delayL = ((NumberExpression)exprs.get(0)).getValue();
        float delayRE = ((NumberExpression)exprs.get(1)).getValue();

        if (delayL == 0 && delayRE != 0) {
            delay = new Delay(Delay.Type.ONBOTHSIDES_TYPE1, exprs);
        } else if (delayL != 0 && delayRE != 0) {
            delay = new Delay(Delay.Type.ONBOTHSIDES_TYPE2, exprs);
        } else if (delayL != 0 && delayRE == 0){
            delay = new Delay(Delay.Type.ONBOTHSIDES_TYPE3, exprs);
        } else {
            throw new RuntimeException("Delay on both sides with wrong parameters: delayL=" + delayL + " , delayRE=" + delayRE);
        }
    }


    @Override public void exitUniversality(RequirementGrammarParser.UniversalityContext ctx) {
        property = new Property(Property.Type.UNIVERSALITY, new VariableExpression(ctx.ID().getText()));
    }

    @Override public void exitAbsence(RequirementGrammarParser.AbsenceContext ctx) {
        property = new Property(Property.Type.ABSENCE, new VariableExpression(ctx.ID().getText()));
    }

    @Override public void exitExistence(RequirementGrammarParser.ExistenceContext ctx) {
        property = new Property(Property.Type.EXISTENCE, new VariableExpression(ctx.ID().getText()));
    }

    @Override public void exitInterlock(RequirementGrammarParser.InterlockContext ctx) {
        scope = new Scope(Scope.Type.INTERLOCK, new ArrayList<>());

        property = new Property(Property.Type.INTERLOCK, new BooleanExpression(
                new VariableExpression(ctx.ID().get(0).getText()),
                new VariableExpression(ctx.ID().get(1).getText()),
                BooleanExpression.Operator.AND
        ));
    }

    @Override public void exitBracketExpression(RequirementGrammarParser.BracketExpressionContext ctx) {
        setValue(ctx, getExpression(ctx.expr()));
    }

    @Override public void exitBooleanExpression(RequirementGrammarParser.BooleanExpressionContext ctx) {
        BooleanExpression.Operator operator = BooleanExpression.getOperator(ctx.getChild(1).getText());
        Expression leftExp = getExpression(ctx.expr(0));
        Expression rightExp = getExpression(ctx.expr(1));
        BooleanExpression expr = new BooleanExpression(leftExp, rightExp, operator);
        setValue(ctx, expr);
    }

    @Override public void exitUnaryExpression(RequirementGrammarParser.UnaryExpressionContext ctx) {
        UnaryExpression.Operator operator = UnaryExpression.getOperator(ctx.getChild(0).getText());
        UnaryExpression uexpr = new UnaryExpression(new VariableExpression(ctx.ID().getText()), operator);
        setValue(ctx, uexpr);
    }

    @Override public void exitVariableExpression(RequirementGrammarParser.VariableExpressionContext ctx) {
       setValue(ctx, new VariableExpression(ctx.ID().getText()));
    }

    @Override public void exitNumberExpression(RequirementGrammarParser.NumberExpressionContext ctx) {
        setValue(ctx, new NumberExpression(Integer.parseInt(ctx.number().getText())));
    }


    /*********************************************
     *  Util Methods
     *********************************************/

    private void setValue(ParseTree node, Object value) { values.put(node, value); }

    private Expression getExpression(RequirementGrammarParser.ExprContext node) { return (Expression)values.get(node); }

    private List<Expression> getExpressionList(List<RequirementGrammarParser.ExprContext> exprContexts) {
        List<Expression> exprList = new ArrayList<>();

        for (RequirementGrammarParser.ExprContext ctx: exprContexts) {
            exprList.add(getExpression(ctx));
        }

        return exprList;
    }


}


