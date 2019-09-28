// Generated from /Users/yaoxinyan/Public/sps2plc/sps2plc-backend/src/antlr/RequirementGrammar.g4 by ANTLR 4.7.2

    package sps2plc.core.fe.sps.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequirementGrammarParser}.
 */
public interface RequirementGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(RequirementGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(RequirementGrammarParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(RequirementGrammarParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(RequirementGrammarParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#reqID}.
	 * @param ctx the parse tree
	 */
	void enterReqID(RequirementGrammarParser.ReqIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#reqID}.
	 * @param ctx the parse tree
	 */
	void exitReqID(RequirementGrammarParser.ReqIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(RequirementGrammarParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(RequirementGrammarParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#delay}.
	 * @param ctx the parse tree
	 */
	void enterDelay(RequirementGrammarParser.DelayContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#delay}.
	 * @param ctx the parse tree
	 */
	void exitDelay(RequirementGrammarParser.DelayContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(RequirementGrammarParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(RequirementGrammarParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#delayWithEnd}.
	 * @param ctx the parse tree
	 */
	void enterDelayWithEnd(RequirementGrammarParser.DelayWithEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#delayWithEnd}.
	 * @param ctx the parse tree
	 */
	void exitDelayWithEnd(RequirementGrammarParser.DelayWithEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#delayWithoutEnd}.
	 * @param ctx the parse tree
	 */
	void enterDelayWithoutEnd(RequirementGrammarParser.DelayWithoutEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#delayWithoutEnd}.
	 * @param ctx the parse tree
	 */
	void exitDelayWithoutEnd(RequirementGrammarParser.DelayWithoutEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#delayOnBothSides}.
	 * @param ctx the parse tree
	 */
	void enterDelayOnBothSides(RequirementGrammarParser.DelayOnBothSidesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#delayOnBothSides}.
	 * @param ctx the parse tree
	 */
	void exitDelayOnBothSides(RequirementGrammarParser.DelayOnBothSidesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#universality}.
	 * @param ctx the parse tree
	 */
	void enterUniversality(RequirementGrammarParser.UniversalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#universality}.
	 * @param ctx the parse tree
	 */
	void exitUniversality(RequirementGrammarParser.UniversalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#absence}.
	 * @param ctx the parse tree
	 */
	void enterAbsence(RequirementGrammarParser.AbsenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#absence}.
	 * @param ctx the parse tree
	 */
	void exitAbsence(RequirementGrammarParser.AbsenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#existence}.
	 * @param ctx the parse tree
	 */
	void enterExistence(RequirementGrammarParser.ExistenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#existence}.
	 * @param ctx the parse tree
	 */
	void exitExistence(RequirementGrammarParser.ExistenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#interlock}.
	 * @param ctx the parse tree
	 */
	void enterInterlock(RequirementGrammarParser.InterlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#interlock}.
	 * @param ctx the parse tree
	 */
	void exitInterlock(RequirementGrammarParser.InterlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketExpression(RequirementGrammarParser.BracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketExpression(RequirementGrammarParser.BracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(RequirementGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(RequirementGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(RequirementGrammarParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(RequirementGrammarParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(RequirementGrammarParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(RequirementGrammarParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(RequirementGrammarParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(RequirementGrammarParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(RequirementGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(RequirementGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequirementGrammarParser#positiveInt}.
	 * @param ctx the parse tree
	 */
	void enterPositiveInt(RequirementGrammarParser.PositiveIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequirementGrammarParser#positiveInt}.
	 * @param ctx the parse tree
	 */
	void exitPositiveInt(RequirementGrammarParser.PositiveIntContext ctx);
}