// Generated from C:/Users/maps/Desktop/java-antlr/src/antlr\RequirementGrammar.g4 by ANTLR 4.7.2

    package sps2plc.core.fe.sps.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RequirementGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, FLOAT=22, POSITIVE_INT=23, ID=24, 
		WS=25, LINE_COMMENT=26;
	public static final int
		RULE_list = 0, RULE_requirement = 1, RULE_reqID = 2, RULE_scope = 3, RULE_delay = 4, 
		RULE_property = 5, RULE_delayWithEnd = 6, RULE_delayWithoutEnd = 7, RULE_delayOnBothSides = 8, 
		RULE_universality = 9, RULE_absence = 10, RULE_existence = 11, RULE_expr = 12, 
		RULE_number = 13, RULE_positiveInt = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"list", "requirement", "reqID", "scope", "delay", "property", "delayWithEnd", 
			"delayWithoutEnd", "delayOnBothSides", "universality", "absence", "existence", 
			"expr", "number", "positiveInt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'['", "']'", "'Globally'", "'After'", "'until'", 
			"'When'", "'delayL'", "'='", "'delayR'", "'delayRE'", "'is'", "'true'", 
			"'false'", "'exists'", "'('", "')'", "'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "FLOAT", 
			"POSITIVE_INT", "ID", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RequirementGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RequirementGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ListContext extends ParserRuleContext {
		public List<RequirementContext> requirement() {
			return getRuleContexts(RequirementContext.class);
		}
		public RequirementContext requirement(int i) {
			return getRuleContext(RequirementContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				requirement();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__7))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RequirementContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ReqIDContext reqID() {
			return getRuleContext(ReqIDContext.class,0);
		}
		public DelayContext delay() {
			return getRuleContext(DelayContext.class,0);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitRequirement(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(35);
				reqID();
				}
			}

			{
			setState(38);
			scope();
			setState(39);
			match(T__0);
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(41);
				delay();
				setState(42);
				match(T__0);
				}
			}

			setState(46);
			property();
			setState(47);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReqIDContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ReqIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reqID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterReqID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitReqID(this);
		}
	}

	public final ReqIDContext reqID() throws RecognitionException {
		ReqIDContext _localctx = new ReqIDContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_reqID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__2);
			setState(50);
			number();
			setState(51);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitScope(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scope);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__5);
				setState(55);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__5);
				setState(57);
				expr(0);
				setState(58);
				match(T__6);
				setState(59);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(T__7);
				setState(62);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelayContext extends ParserRuleContext {
		public DelayWithEndContext delayWithEnd() {
			return getRuleContext(DelayWithEndContext.class,0);
		}
		public DelayWithoutEndContext delayWithoutEnd() {
			return getRuleContext(DelayWithoutEndContext.class,0);
		}
		public DelayOnBothSidesContext delayOnBothSides() {
			return getRuleContext(DelayOnBothSidesContext.class,0);
		}
		public DelayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelay(this);
		}
	}

	public final DelayContext delay() throws RecognitionException {
		DelayContext _localctx = new DelayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_delay);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				delayWithEnd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				delayWithoutEnd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				delayOnBothSides();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public UniversalityContext universality() {
			return getRuleContext(UniversalityContext.class,0);
		}
		public AbsenceContext absence() {
			return getRuleContext(AbsenceContext.class,0);
		}
		public ExistenceContext existence() {
			return getRuleContext(ExistenceContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_property);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				universality();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				absence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				existence();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelayWithEndContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DelayWithEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayWithEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayWithEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayWithEnd(this);
		}
	}

	public final DelayWithEndContext delayWithEnd() throws RecognitionException {
		DelayWithEndContext _localctx = new DelayWithEndContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_delayWithEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__8);
			setState(76);
			match(T__9);
			setState(77);
			expr(0);
			setState(78);
			match(T__0);
			setState(79);
			match(T__10);
			setState(80);
			match(T__9);
			setState(81);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelayWithoutEndContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DelayWithoutEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayWithoutEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayWithoutEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayWithoutEnd(this);
		}
	}

	public final DelayWithoutEndContext delayWithoutEnd() throws RecognitionException {
		DelayWithoutEndContext _localctx = new DelayWithoutEndContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_delayWithoutEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__8);
			setState(84);
			match(T__9);
			setState(85);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelayOnBothSidesContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DelayOnBothSidesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayOnBothSides; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayOnBothSides(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayOnBothSides(this);
		}
	}

	public final DelayOnBothSidesContext delayOnBothSides() throws RecognitionException {
		DelayOnBothSidesContext _localctx = new DelayOnBothSidesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_delayOnBothSides);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__8);
			setState(88);
			match(T__9);
			setState(89);
			expr(0);
			setState(90);
			match(T__0);
			setState(91);
			match(T__11);
			setState(92);
			match(T__9);
			setState(93);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UniversalityContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UniversalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_universality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterUniversality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitUniversality(this);
		}
	}

	public final UniversalityContext universality() throws RecognitionException {
		UniversalityContext _localctx = new UniversalityContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_universality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			expr(0);
			setState(96);
			match(T__12);
			setState(97);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbsenceContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbsenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterAbsence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitAbsence(this);
		}
	}

	public final AbsenceContext absence() throws RecognitionException {
		AbsenceContext _localctx = new AbsenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_absence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			expr(0);
			setState(100);
			match(T__12);
			setState(101);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExistenceContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExistenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterExistence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitExistence(this);
		}
	}

	public final ExistenceContext existence() throws RecognitionException {
		ExistenceContext _localctx = new ExistenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_existence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			expr(0);
			setState(104);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterBracketExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitBracketExpression(this);
		}
	}
	public static class BooleanExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BooleanExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitBooleanExpression(this);
		}
	}
	public static class UnaryExpressionContext extends ExprContext {
		public TerminalNode ID() { return getToken(RequirementGrammarParser.ID, 0); }
		public UnaryExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitUnaryExpression(this);
		}
	}
	public static class VariableExpressionContext extends ExprContext {
		public TerminalNode ID() { return getToken(RequirementGrammarParser.ID, 0); }
		public VariableExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitVariableExpression(this);
		}
	}
	public static class NumberExpressionContext extends ExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitNumberExpression(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				{
				_localctx = new BracketExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(107);
				match(T__16);
				setState(108);
				expr(0);
				setState(109);
				match(T__17);
				}
				break;
			case T__20:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(T__20);
				setState(112);
				match(ID);
				}
				break;
			case ID:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(ID);
				}
				break;
			case FLOAT:
			case POSITIVE_INT:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanExpressionContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(117);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(118);
					_la = _input.LA(1);
					if ( !(_la==T__18 || _la==T__19) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(119);
					expr(5);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode POSITIVE_INT() { return getToken(RequirementGrammarParser.POSITIVE_INT, 0); }
		public TerminalNode FLOAT() { return getToken(RequirementGrammarParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==POSITIVE_INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PositiveIntContext extends ParserRuleContext {
		public TerminalNode POSITIVE_INT() { return getToken(RequirementGrammarParser.POSITIVE_INT, 0); }
		public PositiveIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positiveInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterPositiveInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitPositiveInt(this);
		}
	}

	public final PositiveIntContext positiveInt() throws RecognitionException {
		PositiveIntContext _localctx = new PositiveIntContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_positiveInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(POSITIVE_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2"+
		"\16\2#\3\3\5\3\'\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6\3\6"+
		"\3\6\5\6G\n\6\3\7\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16v\n\16\3\16\3\16\3\16\7\16{\n\16\f\16\16\16~\13\16\3\17\3\17\3\20\3"+
		"\20\3\20\2\3\32\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\25\26"+
		"\3\2\30\31\2\u0082\2!\3\2\2\2\4&\3\2\2\2\6\63\3\2\2\2\bA\3\2\2\2\nF\3"+
		"\2\2\2\fK\3\2\2\2\16M\3\2\2\2\20U\3\2\2\2\22Y\3\2\2\2\24a\3\2\2\2\26e"+
		"\3\2\2\2\30i\3\2\2\2\32u\3\2\2\2\34\177\3\2\2\2\36\u0081\3\2\2\2 \"\5"+
		"\4\3\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%\'\5\6\4\2"+
		"&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\5\b\5\2)*\7\3\2\2*.\3\2\2\2+,\5\n\6"+
		"\2,-\7\3\2\2-/\3\2\2\2.+\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\5\f\7\2\61"+
		"\62\7\4\2\2\62\5\3\2\2\2\63\64\7\5\2\2\64\65\5\34\17\2\65\66\7\6\2\2\66"+
		"\7\3\2\2\2\67B\7\7\2\289\7\b\2\29B\5\32\16\2:;\7\b\2\2;<\5\32\16\2<=\7"+
		"\t\2\2=>\5\32\16\2>B\3\2\2\2?@\7\n\2\2@B\5\32\16\2A\67\3\2\2\2A8\3\2\2"+
		"\2A:\3\2\2\2A?\3\2\2\2B\t\3\2\2\2CG\5\16\b\2DG\5\20\t\2EG\5\22\n\2FC\3"+
		"\2\2\2FD\3\2\2\2FE\3\2\2\2G\13\3\2\2\2HL\5\24\13\2IL\5\26\f\2JL\5\30\r"+
		"\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\r\3\2\2\2MN\7\13\2\2NO\7\f\2\2OP\5\32"+
		"\16\2PQ\7\3\2\2QR\7\r\2\2RS\7\f\2\2ST\5\32\16\2T\17\3\2\2\2UV\7\13\2\2"+
		"VW\7\f\2\2WX\5\32\16\2X\21\3\2\2\2YZ\7\13\2\2Z[\7\f\2\2[\\\5\32\16\2\\"+
		"]\7\3\2\2]^\7\16\2\2^_\7\f\2\2_`\5\32\16\2`\23\3\2\2\2ab\5\32\16\2bc\7"+
		"\17\2\2cd\7\20\2\2d\25\3\2\2\2ef\5\32\16\2fg\7\17\2\2gh\7\21\2\2h\27\3"+
		"\2\2\2ij\5\32\16\2jk\7\22\2\2k\31\3\2\2\2lm\b\16\1\2mn\7\23\2\2no\5\32"+
		"\16\2op\7\24\2\2pv\3\2\2\2qr\7\27\2\2rv\7\32\2\2sv\7\32\2\2tv\5\34\17"+
		"\2ul\3\2\2\2uq\3\2\2\2us\3\2\2\2ut\3\2\2\2v|\3\2\2\2wx\f\6\2\2xy\t\2\2"+
		"\2y{\5\32\16\7zw\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\33\3\2\2\2~|\3"+
		"\2\2\2\177\u0080\t\3\2\2\u0080\35\3\2\2\2\u0081\u0082\7\31\2\2\u0082\37"+
		"\3\2\2\2\n#&.AFKu|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}