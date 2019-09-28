// Generated from /Users/yaoxinyan/Public/sps2plc/sps2plc-backend/src/antlr/RequirementGrammar.g4 by ANTLR 4.7.2

    package sps2plc.core.fe.sps.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RequirementGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, FLOAT=22, POSITIVE_INT=23, ID=24, 
		WS=25, LINE_COMMENT=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "FLOAT", "POSITIVE_INT", "ID", "WS", 
			"LINE_COMMENT", "NONZERODIGIT", "DIGIT", "LETTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'['", "']'", "'Globally'", "'After'", "'until'", 
			"'When'", "'delayL'", "'='", "'delayR'", "'delayRE'", "'is'", "'true'", 
			"'false'", "'exists'", "'('", "'and'", "')'", "'or'", "'not'"
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


	public RequirementGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RequirementGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00ec\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\5\27\u009d\n\27"+
		"\3\27\3\27\6\27\u00a1\n\27\r\27\16\27\u00a2\3\27\6\27\u00a6\n\27\r\27"+
		"\16\27\u00a7\3\27\3\27\7\27\u00ac\n\27\f\27\16\27\u00af\13\27\5\27\u00b1"+
		"\n\27\5\27\u00b3\n\27\3\30\3\30\3\30\7\30\u00b8\n\30\f\30\16\30\u00bb"+
		"\13\30\5\30\u00bd\n\30\3\31\3\31\3\31\5\31\u00c2\n\31\3\31\3\31\3\31\7"+
		"\31\u00c7\n\31\f\31\16\31\u00ca\13\31\3\31\3\31\5\31\u00ce\n\31\5\31\u00d0"+
		"\n\31\3\32\6\32\u00d3\n\32\r\32\16\32\u00d4\3\32\3\32\3\33\3\33\7\33\u00db"+
		"\n\33\f\33\16\33\u00de\13\33\3\33\5\33\u00e1\n\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\u00dc\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\29\2;\2\3\2\6\5\2\13\f\17\17\"\"\3\2"+
		"\63;\3\2\62;\4\2C\\c|\2\u00f9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rN\3\2\2\2\17"+
		"T\3\2\2\2\21Z\3\2\2\2\23_\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31o\3\2\2\2"+
		"\33w\3\2\2\2\35z\3\2\2\2\37\177\3\2\2\2!\u0085\3\2\2\2#\u008c\3\2\2\2"+
		"%\u008e\3\2\2\2\'\u0092\3\2\2\2)\u0094\3\2\2\2+\u0097\3\2\2\2-\u009c\3"+
		"\2\2\2/\u00bc\3\2\2\2\61\u00cf\3\2\2\2\63\u00d2\3\2\2\2\65\u00d8\3\2\2"+
		"\2\67\u00e6\3\2\2\29\u00e8\3\2\2\2;\u00ea\3\2\2\2=>\7.\2\2>\4\3\2\2\2"+
		"?@\7\60\2\2@\6\3\2\2\2AB\7]\2\2B\b\3\2\2\2CD\7_\2\2D\n\3\2\2\2EF\7I\2"+
		"\2FG\7n\2\2GH\7q\2\2HI\7d\2\2IJ\7c\2\2JK\7n\2\2KL\7n\2\2LM\7{\2\2M\f\3"+
		"\2\2\2NO\7C\2\2OP\7h\2\2PQ\7v\2\2QR\7g\2\2RS\7t\2\2S\16\3\2\2\2TU\7w\2"+
		"\2UV\7p\2\2VW\7v\2\2WX\7k\2\2XY\7n\2\2Y\20\3\2\2\2Z[\7Y\2\2[\\\7j\2\2"+
		"\\]\7g\2\2]^\7p\2\2^\22\3\2\2\2_`\7f\2\2`a\7g\2\2ab\7n\2\2bc\7c\2\2cd"+
		"\7{\2\2de\7N\2\2e\24\3\2\2\2fg\7?\2\2g\26\3\2\2\2hi\7f\2\2ij\7g\2\2jk"+
		"\7n\2\2kl\7c\2\2lm\7{\2\2mn\7T\2\2n\30\3\2\2\2op\7f\2\2pq\7g\2\2qr\7n"+
		"\2\2rs\7c\2\2st\7{\2\2tu\7T\2\2uv\7G\2\2v\32\3\2\2\2wx\7k\2\2xy\7u\2\2"+
		"y\34\3\2\2\2z{\7v\2\2{|\7t\2\2|}\7w\2\2}~\7g\2\2~\36\3\2\2\2\177\u0080"+
		"\7h\2\2\u0080\u0081\7c\2\2\u0081\u0082\7n\2\2\u0082\u0083\7u\2\2\u0083"+
		"\u0084\7g\2\2\u0084 \3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087\7z\2\2\u0087"+
		"\u0088\7k\2\2\u0088\u0089\7u\2\2\u0089\u008a\7v\2\2\u008a\u008b\7u\2\2"+
		"\u008b\"\3\2\2\2\u008c\u008d\7*\2\2\u008d$\3\2\2\2\u008e\u008f\7c\2\2"+
		"\u008f\u0090\7p\2\2\u0090\u0091\7f\2\2\u0091&\3\2\2\2\u0092\u0093\7+\2"+
		"\2\u0093(\3\2\2\2\u0094\u0095\7q\2\2\u0095\u0096\7t\2\2\u0096*\3\2\2\2"+
		"\u0097\u0098\7p\2\2\u0098\u0099\7q\2\2\u0099\u009a\7v\2\2\u009a,\3\2\2"+
		"\2\u009b\u009d\7/\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00b2"+
		"\3\2\2\2\u009e\u00a0\7\60\2\2\u009f\u00a1\59\35\2\u00a0\u009f\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00b3"+
		"\3\2\2\2\u00a4\u00a6\59\35\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00b0\3\2\2\2\u00a9\u00ad\7\60"+
		"\2\2\u00aa\u00ac\59\35\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00a9\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u009e\3\2\2\2\u00b2\u00a5\3\2\2\2\u00b3.\3\2\2\2\u00b4\u00bd\59\35\2"+
		"\u00b5\u00b9\5\67\34\2\u00b6\u00b8\59\35\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb"+
		"\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bd\60\3\2\2"+
		"\2\u00be\u00d0\5;\36\2\u00bf\u00c2\5;\36\2\u00c0\u00c2\59\35\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c8\3\2\2\2\u00c3\u00c7\5;\36\2\u00c4"+
		"\u00c7\59\35\2\u00c5\u00c7\7\60\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3"+
		"\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\5;"+
		"\36\2\u00cc\u00ce\59\35\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00d0\3\2\2\2\u00cf\u00be\3\2\2\2\u00cf\u00c1\3\2\2\2\u00d0\62\3\2\2"+
		"\2\u00d1\u00d3\t\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\32\2\2"+
		"\u00d7\64\3\2\2\2\u00d8\u00dc\7%\2\2\u00d9\u00db\13\2\2\2\u00da\u00d9"+
		"\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e1\7\17\2\2\u00e0\u00df\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\f\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e5\b\33\2\2\u00e5\66\3\2\2\2\u00e6\u00e7\t\3\2"+
		"\2\u00e78\3\2\2\2\u00e8\u00e9\t\4\2\2\u00e9:\3\2\2\2\u00ea\u00eb\t\5\2"+
		"\2\u00eb<\3\2\2\2\23\2\u009c\u00a2\u00a7\u00ad\u00b0\u00b2\u00b9\u00bc"+
		"\u00c1\u00c6\u00c8\u00cd\u00cf\u00d4\u00dc\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}