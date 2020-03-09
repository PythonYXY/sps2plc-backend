// Generated from /Users/yaoxinyan/Public/sps2plc/sps2plc-backend-maven/src/antlr/RequirementGrammar.g4 by ANTLR 4.8

    package sps2plc.core.fe.sps.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(RequirementGrammarParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(RequirementGrammarParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#reqID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqID(RequirementGrammarParser.ReqIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(RequirementGrammarParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelay(RequirementGrammarParser.DelayContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(RequirementGrammarParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delayWithEnd1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayWithEnd1(RequirementGrammarParser.DelayWithEnd1Context ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delayWithEnd2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayWithEnd2(RequirementGrammarParser.DelayWithEnd2Context ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delayWithoutEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayWithoutEnd(RequirementGrammarParser.DelayWithoutEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delayOnBothSides}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayOnBothSides(RequirementGrammarParser.DelayOnBothSidesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#delayOnRightSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayOnRightSide(RequirementGrammarParser.DelayOnRightSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#universality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversality(RequirementGrammarParser.UniversalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#absence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsence(RequirementGrammarParser.AbsenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#existence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistence(RequirementGrammarParser.ExistenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#interlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterlock(RequirementGrammarParser.InterlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketExpression(RequirementGrammarParser.BracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(RequirementGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(RequirementGrammarParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(RequirementGrammarParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberExpression}
	 * labeled alternative in {@link RequirementGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(RequirementGrammarParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(RequirementGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementGrammarParser#positiveInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveInt(RequirementGrammarParser.PositiveIntContext ctx);
}