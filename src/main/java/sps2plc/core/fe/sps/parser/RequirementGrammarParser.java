// Generated from /Users/yaoxinyan/Public/sps2plc/sps2plc-backend-maven/src/antlr/RequirementGrammar.g4 by ANTLR 4.8

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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, FLOAT=35, POSITIVE_INT=36, ID=37, WS=38, 
		LINE_COMMENT=39;
	public static final int
		RULE_list = 0, RULE_requirement = 1, RULE_reqID = 2, RULE_scope = 3, RULE_delay = 4, 
		RULE_property = 5, RULE_delayWithEnd1 = 6, RULE_delayWithEnd2 = 7, RULE_delayWithoutEnd = 8, 
		RULE_delayOnBothSides = 9, RULE_delayOnRightSide = 10, RULE_universality = 11, 
		RULE_absence = 12, RULE_existence = 13, RULE_interlock = 14, RULE_expr = 15, 
		RULE_number = 16, RULE_positiveInt = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"list", "requirement", "reqID", "scope", "delay", "property", "delayWithEnd1", 
			"delayWithEnd2", "delayWithoutEnd", "delayOnBothSides", "delayOnRightSide", 
			"universality", "absence", "existence", "interlock", "expr", "number", 
			"positiveInt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'['", "']'", "'Globally'", "'After'", "'until'", 
			"'When'", "'between'", "'timeUnits'", "'and'", "'within'", "'after'", 
			"'the'", "'property'", "'still'", "'holds'", "'for'", "'end'", "'of'", 
			"'scope'", "'it'", "'is'", "'always'", "'case'", "'that'", "'never'", 
			"'exists'", "'immediately'", "'('", "')'", "'hold'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "FLOAT", 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				requirement();
				}
				}
				setState(39); 
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_requirement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(41);
				reqID();
				}
			}

			setState(44);
			scope();
			setState(45);
			match(T__0);
			setState(46);
			property();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) {
				{
				setState(47);
				delay();
				}
			}

			setState(50);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitReqID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqIDContext reqID() throws RecognitionException {
		ReqIDContext _localctx = new ReqIDContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_reqID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__2);
			setState(53);
			number();
			setState(54);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scope);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__5);
				setState(58);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__5);
				setState(60);
				expr(0);
				setState(61);
				match(T__6);
				setState(62);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(T__7);
				setState(65);
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
		public DelayWithEnd1Context delayWithEnd1() {
			return getRuleContext(DelayWithEnd1Context.class,0);
		}
		public DelayWithEnd2Context delayWithEnd2() {
			return getRuleContext(DelayWithEnd2Context.class,0);
		}
		public DelayWithoutEndContext delayWithoutEnd() {
			return getRuleContext(DelayWithoutEndContext.class,0);
		}
		public DelayOnBothSidesContext delayOnBothSides() {
			return getRuleContext(DelayOnBothSidesContext.class,0);
		}
		public DelayOnRightSideContext delayOnRightSide() {
			return getRuleContext(DelayOnRightSideContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayContext delay() throws RecognitionException {
		DelayContext _localctx = new DelayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_delay);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				delayWithEnd1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				delayWithEnd2();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				delayWithoutEnd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				delayOnBothSides();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				delayOnRightSide();
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
		public InterlockContext interlock() {
			return getRuleContext(InterlockContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_property);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				universality();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				absence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				existence();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				interlock();
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

	public static class DelayWithEnd1Context extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DelayWithEnd1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayWithEnd1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayWithEnd1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayWithEnd1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelayWithEnd1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayWithEnd1Context delayWithEnd1() throws RecognitionException {
		DelayWithEnd1Context _localctx = new DelayWithEnd1Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_delayWithEnd1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__8);
			setState(82);
			expr(0);
			setState(83);
			match(T__9);
			setState(84);
			match(T__10);
			setState(85);
			expr(0);
			setState(86);
			match(T__9);
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

	public static class DelayWithEnd2Context extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DelayWithEnd2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayWithEnd2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayWithEnd2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayWithEnd2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelayWithEnd2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayWithEnd2Context delayWithEnd2() throws RecognitionException {
		DelayWithEnd2Context _localctx = new DelayWithEnd2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_delayWithEnd2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__11);
			setState(89);
			expr(0);
			setState(90);
			match(T__9);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelayWithoutEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayWithoutEndContext delayWithoutEnd() throws RecognitionException {
		DelayWithoutEndContext _localctx = new DelayWithoutEndContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_delayWithoutEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__12);
			setState(93);
			expr(0);
			setState(94);
			match(T__9);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelayOnBothSides(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayOnBothSidesContext delayOnBothSides() throws RecognitionException {
		DelayOnBothSidesContext _localctx = new DelayOnBothSidesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_delayOnBothSides);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__12);
			setState(97);
			expr(0);
			setState(98);
			match(T__9);
			setState(99);
			match(T__10);
			setState(100);
			match(T__13);
			setState(101);
			match(T__14);
			setState(102);
			match(T__15);
			setState(103);
			match(T__16);
			setState(104);
			match(T__17);
			setState(105);
			expr(0);
			setState(106);
			match(T__9);
			setState(107);
			match(T__12);
			setState(108);
			match(T__13);
			setState(109);
			match(T__18);
			setState(110);
			match(T__19);
			setState(111);
			match(T__13);
			setState(112);
			match(T__20);
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

	public static class DelayOnRightSideContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DelayOnRightSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delayOnRightSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterDelayOnRightSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitDelayOnRightSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitDelayOnRightSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayOnRightSideContext delayOnRightSide() throws RecognitionException {
		DelayOnRightSideContext _localctx = new DelayOnRightSideContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_delayOnRightSide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__10);
			setState(115);
			match(T__13);
			setState(116);
			match(T__14);
			setState(117);
			match(T__15);
			setState(118);
			match(T__16);
			setState(119);
			match(T__17);
			setState(120);
			expr(0);
			setState(121);
			match(T__9);
			setState(122);
			match(T__12);
			setState(123);
			match(T__13);
			setState(124);
			match(T__18);
			setState(125);
			match(T__19);
			setState(126);
			match(T__13);
			setState(127);
			match(T__20);
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
		public TerminalNode ID() { return getToken(RequirementGrammarParser.ID, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitUniversality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniversalityContext universality() throws RecognitionException {
		UniversalityContext _localctx = new UniversalityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_universality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__21);
			setState(130);
			match(T__22);
			setState(131);
			match(T__23);
			setState(132);
			match(T__13);
			setState(133);
			match(T__24);
			setState(134);
			match(T__25);
			setState(135);
			match(ID);
			setState(136);
			match(T__16);
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
		public TerminalNode ID() { return getToken(RequirementGrammarParser.ID, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitAbsence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsenceContext absence() throws RecognitionException {
		AbsenceContext _localctx = new AbsenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_absence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__21);
			setState(139);
			match(T__22);
			setState(140);
			match(T__26);
			setState(141);
			match(T__13);
			setState(142);
			match(T__24);
			setState(143);
			match(T__25);
			setState(144);
			match(ID);
			setState(145);
			match(T__16);
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
		public TerminalNode ID() { return getToken(RequirementGrammarParser.ID, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitExistence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistenceContext existence() throws RecognitionException {
		ExistenceContext _localctx = new ExistenceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_existence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(ID);
			setState(148);
			match(T__27);
			setState(149);
			match(T__28);
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

	public static class InterlockContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RequirementGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequirementGrammarParser.ID, i);
		}
		public InterlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).enterInterlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementGrammarListener ) ((RequirementGrammarListener)listener).exitInterlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitInterlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterlockContext interlock() throws RecognitionException {
		InterlockContext _localctx = new InterlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_interlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__21);
			setState(152);
			match(T__22);
			setState(153);
			match(T__26);
			setState(154);
			match(T__13);
			setState(155);
			match(T__24);
			setState(156);
			match(T__25);
			setState(157);
			match(T__29);
			setState(158);
			match(ID);
			setState(159);
			match(T__10);
			setState(160);
			match(ID);
			setState(161);
			match(T__30);
			setState(162);
			match(T__31);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitBracketExpression(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				{
				_localctx = new BracketExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				match(T__29);
				setState(166);
				expr(0);
				setState(167);
				match(T__30);
				}
				break;
			case T__33:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__33);
				setState(170);
				match(ID);
				}
				break;
			case ID:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(ID);
				}
				break;
			case FLOAT:
			case POSITIVE_INT:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
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
					setState(175);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(176);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__32) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(177);
					expr(5);
					}
					} 
				}
				setState(182);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementGrammarVisitor ) return ((RequirementGrammarVisitor<? extends T>)visitor).visitPositiveInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositiveIntContext positiveInt() throws RecognitionException {
		PositiveIntContext _localctx = new PositiveIntContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_positiveInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\5\3\63"+
		"\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5E\n\5\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\5\7R\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00b0\n\21\3\21\3\21\3\21\7\21\u00b5\n\21\f\21\16\21\u00b8\13\21\3\22"+
		"\3\22\3\23\3\23\3\23\2\3 \24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$\2\4\4\2\r\r##\3\2%&\2\u00bc\2\'\3\2\2\2\4,\3\2\2\2\6\66\3\2\2\2\bD\3"+
		"\2\2\2\nK\3\2\2\2\fQ\3\2\2\2\16S\3\2\2\2\20Z\3\2\2\2\22^\3\2\2\2\24b\3"+
		"\2\2\2\26t\3\2\2\2\30\u0083\3\2\2\2\32\u008c\3\2\2\2\34\u0095\3\2\2\2"+
		"\36\u0099\3\2\2\2 \u00af\3\2\2\2\"\u00b9\3\2\2\2$\u00bb\3\2\2\2&(\5\4"+
		"\3\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+-\5\6\4\2,+"+
		"\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\5\b\5\2/\60\7\3\2\2\60\62\5\f\7\2\61\63"+
		"\5\n\6\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\4\2\2\65\5"+
		"\3\2\2\2\66\67\7\5\2\2\678\5\"\22\289\7\6\2\29\7\3\2\2\2:E\7\7\2\2;<\7"+
		"\b\2\2<E\5 \21\2=>\7\b\2\2>?\5 \21\2?@\7\t\2\2@A\5 \21\2AE\3\2\2\2BC\7"+
		"\n\2\2CE\5 \21\2D:\3\2\2\2D;\3\2\2\2D=\3\2\2\2DB\3\2\2\2E\t\3\2\2\2FL"+
		"\5\16\b\2GL\5\20\t\2HL\5\22\n\2IL\5\24\13\2JL\5\26\f\2KF\3\2\2\2KG\3\2"+
		"\2\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MR\5\30\r\2NR\5\32\16\2"+
		"OR\5\34\17\2PR\5\36\20\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\r\3"+
		"\2\2\2ST\7\13\2\2TU\5 \21\2UV\7\f\2\2VW\7\r\2\2WX\5 \21\2XY\7\f\2\2Y\17"+
		"\3\2\2\2Z[\7\16\2\2[\\\5 \21\2\\]\7\f\2\2]\21\3\2\2\2^_\7\17\2\2_`\5 "+
		"\21\2`a\7\f\2\2a\23\3\2\2\2bc\7\17\2\2cd\5 \21\2de\7\f\2\2ef\7\r\2\2f"+
		"g\7\20\2\2gh\7\21\2\2hi\7\22\2\2ij\7\23\2\2jk\7\24\2\2kl\5 \21\2lm\7\f"+
		"\2\2mn\7\17\2\2no\7\20\2\2op\7\25\2\2pq\7\26\2\2qr\7\20\2\2rs\7\27\2\2"+
		"s\25\3\2\2\2tu\7\r\2\2uv\7\20\2\2vw\7\21\2\2wx\7\22\2\2xy\7\23\2\2yz\7"+
		"\24\2\2z{\5 \21\2{|\7\f\2\2|}\7\17\2\2}~\7\20\2\2~\177\7\25\2\2\177\u0080"+
		"\7\26\2\2\u0080\u0081\7\20\2\2\u0081\u0082\7\27\2\2\u0082\27\3\2\2\2\u0083"+
		"\u0084\7\30\2\2\u0084\u0085\7\31\2\2\u0085\u0086\7\32\2\2\u0086\u0087"+
		"\7\20\2\2\u0087\u0088\7\33\2\2\u0088\u0089\7\34\2\2\u0089\u008a\7\'\2"+
		"\2\u008a\u008b\7\23\2\2\u008b\31\3\2\2\2\u008c\u008d\7\30\2\2\u008d\u008e"+
		"\7\31\2\2\u008e\u008f\7\35\2\2\u008f\u0090\7\20\2\2\u0090\u0091\7\33\2"+
		"\2\u0091\u0092\7\34\2\2\u0092\u0093\7\'\2\2\u0093\u0094\7\23\2\2\u0094"+
		"\33\3\2\2\2\u0095\u0096\7\'\2\2\u0096\u0097\7\36\2\2\u0097\u0098\7\37"+
		"\2\2\u0098\35\3\2\2\2\u0099\u009a\7\30\2\2\u009a\u009b\7\31\2\2\u009b"+
		"\u009c\7\35\2\2\u009c\u009d\7\20\2\2\u009d\u009e\7\33\2\2\u009e\u009f"+
		"\7\34\2\2\u009f\u00a0\7 \2\2\u00a0\u00a1\7\'\2\2\u00a1\u00a2\7\r\2\2\u00a2"+
		"\u00a3\7\'\2\2\u00a3\u00a4\7!\2\2\u00a4\u00a5\7\"\2\2\u00a5\37\3\2\2\2"+
		"\u00a6\u00a7\b\21\1\2\u00a7\u00a8\7 \2\2\u00a8\u00a9\5 \21\2\u00a9\u00aa"+
		"\7!\2\2\u00aa\u00b0\3\2\2\2\u00ab\u00ac\7$\2\2\u00ac\u00b0\7\'\2\2\u00ad"+
		"\u00b0\7\'\2\2\u00ae\u00b0\5\"\22\2\u00af\u00a6\3\2\2\2\u00af\u00ab\3"+
		"\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b6\3\2\2\2\u00b1"+
		"\u00b2\f\6\2\2\u00b2\u00b3\t\2\2\2\u00b3\u00b5\5 \21\7\u00b4\u00b1\3\2"+
		"\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"!\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\t\3\2\2\u00ba#\3\2\2\2\u00bb"+
		"\u00bc\7&\2\2\u00bc%\3\2\2\2\n),\62DKQ\u00af\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}