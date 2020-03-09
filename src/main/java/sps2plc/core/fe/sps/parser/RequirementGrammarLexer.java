// Generated from /Users/yaoxinyan/Public/sps2plc/sps2plc-backend-maven/src/antlr/RequirementGrammar.g4 by ANTLR 4.8

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
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "FLOAT", "POSITIVE_INT", "ID", "WS", "LINE_COMMENT", "NONZERODIGIT", 
			"DIGIT", "LETTER", "CHINESE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0161\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\5$\u010a\n$\3$\3$\6$\u010e\n$\r"+
		"$\16$\u010f\3$\6$\u0113\n$\r$\16$\u0114\3$\3$\7$\u0119\n$\f$\16$\u011c"+
		"\13$\5$\u011e\n$\5$\u0120\n$\3%\3%\3%\7%\u0125\n%\f%\16%\u0128\13%\5%"+
		"\u012a\n%\3&\3&\5&\u012e\n&\3&\3&\3&\5&\u0133\n&\3&\3&\3&\3&\7&\u0139"+
		"\n&\f&\16&\u013c\13&\3&\3&\3&\5&\u0141\n&\5&\u0143\n&\3\'\6\'\u0146\n"+
		"\'\r\'\16\'\u0147\3\'\3\'\3(\3(\7(\u014e\n(\f(\16(\u0151\13(\3(\5(\u0154"+
		"\n(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3\u014f\2-\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q\2S\2U\2W\2\3\2\7\5\2\13\f\17\17\"\"\3\2\63;\3\2\62;\4\2C\\c|\4\2"+
		"\u4e02\u9fa7\uff0a\uff0b\2\u0171\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rj\3"+
		"\2\2\2\17p\3\2\2\2\21v\3\2\2\2\23{\3\2\2\2\25\u0083\3\2\2\2\27\u008d\3"+
		"\2\2\2\31\u0091\3\2\2\2\33\u0098\3\2\2\2\35\u009e\3\2\2\2\37\u00a2\3\2"+
		"\2\2!\u00ab\3\2\2\2#\u00b1\3\2\2\2%\u00b7\3\2\2\2\'\u00bb\3\2\2\2)\u00bf"+
		"\3\2\2\2+\u00c2\3\2\2\2-\u00c8\3\2\2\2/\u00cb\3\2\2\2\61\u00ce\3\2\2\2"+
		"\63\u00d5\3\2\2\2\65\u00da\3\2\2\2\67\u00df\3\2\2\29\u00e5\3\2\2\2;\u00ec"+
		"\3\2\2\2=\u00f8\3\2\2\2?\u00fa\3\2\2\2A\u00fc\3\2\2\2C\u0101\3\2\2\2E"+
		"\u0104\3\2\2\2G\u0109\3\2\2\2I\u0129\3\2\2\2K\u0142\3\2\2\2M\u0145\3\2"+
		"\2\2O\u014b\3\2\2\2Q\u0159\3\2\2\2S\u015b\3\2\2\2U\u015d\3\2\2\2W\u015f"+
		"\3\2\2\2YZ\7.\2\2Z\4\3\2\2\2[\\\7\60\2\2\\\6\3\2\2\2]^\7]\2\2^\b\3\2\2"+
		"\2_`\7_\2\2`\n\3\2\2\2ab\7I\2\2bc\7n\2\2cd\7q\2\2de\7d\2\2ef\7c\2\2fg"+
		"\7n\2\2gh\7n\2\2hi\7{\2\2i\f\3\2\2\2jk\7C\2\2kl\7h\2\2lm\7v\2\2mn\7g\2"+
		"\2no\7t\2\2o\16\3\2\2\2pq\7w\2\2qr\7p\2\2rs\7v\2\2st\7k\2\2tu\7n\2\2u"+
		"\20\3\2\2\2vw\7Y\2\2wx\7j\2\2xy\7g\2\2yz\7p\2\2z\22\3\2\2\2{|\7d\2\2|"+
		"}\7g\2\2}~\7v\2\2~\177\7y\2\2\177\u0080\7g\2\2\u0080\u0081\7g\2\2\u0081"+
		"\u0082\7p\2\2\u0082\24\3\2\2\2\u0083\u0084\7v\2\2\u0084\u0085\7k\2\2\u0085"+
		"\u0086\7o\2\2\u0086\u0087\7g\2\2\u0087\u0088\7W\2\2\u0088\u0089\7p\2\2"+
		"\u0089\u008a\7k\2\2\u008a\u008b\7v\2\2\u008b\u008c\7u\2\2\u008c\26\3\2"+
		"\2\2\u008d\u008e\7c\2\2\u008e\u008f\7p\2\2\u008f\u0090\7f\2\2\u0090\30"+
		"\3\2\2\2\u0091\u0092\7y\2\2\u0092\u0093\7k\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7j\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\32\3\2\2\2\u0098"+
		"\u0099\7c\2\2\u0099\u009a\7h\2\2\u009a\u009b\7v\2\2\u009b\u009c\7g\2\2"+
		"\u009c\u009d\7t\2\2\u009d\34\3\2\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7"+
		"j\2\2\u00a0\u00a1\7g\2\2\u00a1\36\3\2\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4"+
		"\7t\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7t\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7{\2\2\u00aa \3\2\2\2\u00ab"+
		"\u00ac\7u\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2"+
		"\u00af\u00b0\7n\2\2\u00b0\"\3\2\2\2\u00b1\u00b2\7j\2\2\u00b2\u00b3\7q"+
		"\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7u\2\2\u00b6$\3"+
		"\2\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7t\2\2\u00ba"+
		"&\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7f\2\2\u00be"+
		"(\3\2\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7h\2\2\u00c1*\3\2\2\2\u00c2\u00c3"+
		"\7u\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7r\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7,\3\2\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		".\3\2\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7u\2\2\u00cd\60\3\2\2\2\u00ce"+
		"\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7y\2\2\u00d1\u00d2\7c\2\2"+
		"\u00d2\u00d3\7{\2\2\u00d3\u00d4\7u\2\2\u00d4\62\3\2\2\2\u00d5\u00d6\7"+
		"e\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7g\2\2\u00d9\64"+
		"\3\2\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd\7c\2\2\u00dd"+
		"\u00de\7v\2\2\u00de\66\3\2\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"\u00e2\7x\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7t\2\2\u00e48\3\2\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\u00e7\7z\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7u\2\2"+
		"\u00e9\u00ea\7v\2\2\u00ea\u00eb\7u\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7k\2"+
		"\2\u00ed\u00ee\7o\2\2\u00ee\u00ef\7o\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1"+
		"\7f\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00f5\7g\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7{\2\2\u00f7<\3\2\2\2\u00f8"+
		"\u00f9\7*\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7+\2\2\u00fb@\3\2\2\2\u00fc\u00fd"+
		"\7j\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7f\2\2\u0100"+
		"B\3\2\2\2\u0101\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103D\3\2\2\2\u0104\u0105"+
		"\7p\2\2\u0105\u0106\7q\2\2\u0106\u0107\7v\2\2\u0107F\3\2\2\2\u0108\u010a"+
		"\7/\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u011f\3\2\2\2\u010b"+
		"\u010d\7\60\2\2\u010c\u010e\5S*\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0120\3\2\2\2\u0111"+
		"\u0113\5S*\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2"+
		"\2\u0114\u0115\3\2\2\2\u0115\u011d\3\2\2\2\u0116\u011a\7\60\2\2\u0117"+
		"\u0119\5S*\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2"+
		"\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0116"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u010b\3\2\2\2\u011f"+
		"\u0112\3\2\2\2\u0120H\3\2\2\2\u0121\u012a\5S*\2\u0122\u0126\5Q)\2\u0123"+
		"\u0125\5S*\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2"+
		"\2\u0126\u0127\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u0121"+
		"\3\2\2\2\u0129\u0122\3\2\2\2\u012aJ\3\2\2\2\u012b\u012e\5U+\2\u012c\u012e"+
		"\5W,\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0143\3\2\2\2\u012f"+
		"\u0133\5U+\2\u0130\u0133\5S*\2\u0131\u0133\5W,\2\u0132\u012f\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0131\3\2\2\2\u0133\u013a\3\2\2\2\u0134\u0139\5U"+
		"+\2\u0135\u0139\5S*\2\u0136\u0139\7\60\2\2\u0137\u0139\5W,\2\u0138\u0134"+
		"\3\2\2\2\u0138\u0135\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0140\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013d\u0141\5U+\2\u013e\u0141\5S*\2\u013f\u0141"+
		"\5W,\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u012d\3\2\2\2\u0142\u0132\3\2\2\2\u0143L\3\2\2\2"+
		"\u0144\u0146\t\2\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b\'\2\2\u014a"+
		"N\3\2\2\2\u014b\u014f\7%\2\2\u014c\u014e\13\2\2\2\u014d\u014c\3\2\2\2"+
		"\u014e\u0151\3\2\2\2\u014f\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0153"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\7\17\2\2\u0153\u0152\3\2\2\2"+
		"\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7\f\2\2\u0156\u0157"+
		"\3\2\2\2\u0157\u0158\b(\2\2\u0158P\3\2\2\2\u0159\u015a\t\3\2\2\u015aR"+
		"\3\2\2\2\u015b\u015c\t\4\2\2\u015cT\3\2\2\2\u015d\u015e\t\5\2\2\u015e"+
		"V\3\2\2\2\u015f\u0160\t\6\2\2\u0160X\3\2\2\2\24\2\u0109\u010f\u0114\u011a"+
		"\u011d\u011f\u0126\u0129\u012d\u0132\u0138\u013a\u0140\u0142\u0147\u014f"+
		"\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}