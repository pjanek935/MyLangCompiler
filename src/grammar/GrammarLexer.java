// Generated from C:\Users\Piotrek\Grammar.g4 by ANTLR 4.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, RET=5, SQB_LEFT=6, SQB_RIGHT=7, BR_OPEN=8, 
		BR_CLOSE=9, PLUS=10, MINUS=11, DIV=12, MUL=13, EQUAL=14, NEW_LINE=15, 
		SMALL_LETTER=16, BIG_LETTER=17, DIGIT=18, UNDERSCORE=19, GETINT=20, GETFLOAT=21, 
		PRINTS=22, PRINT=23, INTEGER=24, FLOAT=25, QM=26, STRING=27, STRING_NAME=28, 
		IF=29, ELSE=30, FOR=31, GRATER=32, LESS=33, GOQ=34, LOQ=35, EQ=36, COMMA=37, 
		ENDFUNCTION=38, GLOBAL=39, REPEAT=40, ENDREPEAT=41, ENDIF=42, FUNCTION=43, 
		VOID=44, WS=45, COMMENT=46, LINE_COMMENT=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'#'", "'include'", "'INCLUDE'", "'.'", "RET", "'['", "']'", "'('", "')'", 
		"'+'", "'-'", "'/'", "'*'", "'='", "'\n'", "SMALL_LETTER", "BIG_LETTER", 
		"DIGIT", "'_'", "GETINT", "GETFLOAT", "PRINTS", "PRINT", "INTEGER", "FLOAT", 
		"'\"'", "STRING", "STRING_NAME", "IF", "ELSE", "FOR", "'>'", "'<'", "'>='", 
		"'<='", "'=='", "','", "ENDFUNCTION", "GLOBAL", "REPEAT", "ENDREPEAT", 
		"ENDIF", "FUNCTION", "VOID", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "RET", "SQB_LEFT", "SQB_RIGHT", "BR_OPEN", 
		"BR_CLOSE", "PLUS", "MINUS", "DIV", "MUL", "EQUAL", "NEW_LINE", "SMALL_LETTER", 
		"BIG_LETTER", "DIGIT", "UNDERSCORE", "GETINT", "GETFLOAT", "PRINTS", "PRINT", 
		"INTEGER", "FLOAT", "QM", "STRING", "STRING_NAME", "IF", "ELSE", "FOR", 
		"GRATER", "LESS", "GOQ", "LOQ", "EQ", "COMMA", "ENDFUNCTION", "GLOBAL", 
		"REPEAT", "ENDREPEAT", "ENDIF", "FUNCTION", "VOID", "WS", "COMMENT", "LINE_COMMENT"
	};


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44: WS_action((RuleContext)_localctx, actionIndex); break;

		case 45: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 46: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\61\u01c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6|\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00a6"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00b8\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u00c5\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u00d1\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00e4\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00f0\n\32\3\33\3\33\3\34\3\34"+
		"\6\34\u00f6\n\34\r\34\16\34\u00f7\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0108\n\35\3\36\3\36\3\36\3\36"+
		"\5\36\u010e\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0118\n"+
		"\37\3 \3 \3 \3 \3 \3 \5 \u0120\n \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0147\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\5(\u0155\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0163\n)"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0177\n*\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0183\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\5,\u0195\n,\3-\3-\3-\3-\3-\3-\3-\3-\5-\u019f\n-\3."+
		"\6.\u01a2\n.\r.\16.\u01a3\3.\3.\3/\3/\3/\3/\7/\u01ac\n/\f/\16/\u01af\13"+
		"/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u01ba\n\60\f\60\16\60\u01bd"+
		"\13\60\3\60\3\60\3\u01ad\61\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67"+
		"\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,"+
		"\1W-\1Y.\1[/\2]\60\3_\61\4\3\2\b\3\2c|\3\2C\\\3\2\62;\7\2\"\"\62;C\\a"+
		"ac|\5\2\13\13\17\17\"\"\4\2\f\f\17\17\u01d6\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7k\3\2\2"+
		"\2\ts\3\2\2\2\13{\3\2\2\2\r}\3\2\2\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23"+
		"\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31\u0089\3\2\2\2\33\u008b"+
		"\3\2\2\2\35\u008d\3\2\2\2\37\u008f\3\2\2\2!\u0091\3\2\2\2#\u0093\3\2\2"+
		"\2%\u0095\3\2\2\2\'\u0097\3\2\2\2)\u00a5\3\2\2\2+\u00b7\3\2\2\2-\u00c4"+
		"\3\2\2\2/\u00d0\3\2\2\2\61\u00e3\3\2\2\2\63\u00ef\3\2\2\2\65\u00f1\3\2"+
		"\2\2\67\u00f3\3\2\2\29\u0107\3\2\2\2;\u010d\3\2\2\2=\u0117\3\2\2\2?\u011f"+
		"\3\2\2\2A\u0121\3\2\2\2C\u0123\3\2\2\2E\u0125\3\2\2\2G\u0128\3\2\2\2I"+
		"\u012b\3\2\2\2K\u012e\3\2\2\2M\u0146\3\2\2\2O\u0154\3\2\2\2Q\u0162\3\2"+
		"\2\2S\u0176\3\2\2\2U\u0182\3\2\2\2W\u0194\3\2\2\2Y\u019e\3\2\2\2[\u01a1"+
		"\3\2\2\2]\u01a7\3\2\2\2_\u01b5\3\2\2\2ab\7%\2\2b\4\3\2\2\2cd\7k\2\2de"+
		"\7p\2\2ef\7e\2\2fg\7n\2\2gh\7w\2\2hi\7f\2\2ij\7g\2\2j\6\3\2\2\2kl\7K\2"+
		"\2lm\7P\2\2mn\7E\2\2no\7N\2\2op\7W\2\2pq\7F\2\2qr\7G\2\2r\b\3\2\2\2st"+
		"\7\60\2\2t\n\3\2\2\2uv\7t\2\2vw\7g\2\2w|\7v\2\2xy\7T\2\2yz\7G\2\2z|\7"+
		"V\2\2{u\3\2\2\2{x\3\2\2\2|\f\3\2\2\2}~\7]\2\2~\16\3\2\2\2\177\u0080\7"+
		"_\2\2\u0080\20\3\2\2\2\u0081\u0082\7*\2\2\u0082\22\3\2\2\2\u0083\u0084"+
		"\7+\2\2\u0084\24\3\2\2\2\u0085\u0086\7-\2\2\u0086\26\3\2\2\2\u0087\u0088"+
		"\7/\2\2\u0088\30\3\2\2\2\u0089\u008a\7\61\2\2\u008a\32\3\2\2\2\u008b\u008c"+
		"\7,\2\2\u008c\34\3\2\2\2\u008d\u008e\7?\2\2\u008e\36\3\2\2\2\u008f\u0090"+
		"\7\f\2\2\u0090 \3\2\2\2\u0091\u0092\t\2\2\2\u0092\"\3\2\2\2\u0093\u0094"+
		"\t\3\2\2\u0094$\3\2\2\2\u0095\u0096\t\4\2\2\u0096&\3\2\2\2\u0097\u0098"+
		"\7a\2\2\u0098(\3\2\2\2\u0099\u009a\7i\2\2\u009a\u009b\7g\2\2\u009b\u009c"+
		"\7v\2\2\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u00a6\7v\2\2\u009f"+
		"\u00a0\7I\2\2\u00a0\u00a1\7G\2\2\u00a1\u00a2\7V\2\2\u00a2\u00a3\7K\2\2"+
		"\u00a3\u00a4\7P\2\2\u00a4\u00a6\7V\2\2\u00a5\u0099\3\2\2\2\u00a5\u009f"+
		"\3\2\2\2\u00a6*\3\2\2\2\u00a7\u00a8\7I\2\2\u00a8\u00a9\7G\2\2\u00a9\u00aa"+
		"\7V\2\2\u00aa\u00ab\7H\2\2\u00ab\u00ac\7N\2\2\u00ac\u00ad\7Q\2\2\u00ad"+
		"\u00ae\7C\2\2\u00ae\u00b8\7V\2\2\u00af\u00b0\7i\2\2\u00b0\u00b1\7g\2\2"+
		"\u00b1\u00b2\7v\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5"+
		"\7q\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b8\7v\2\2\u00b7\u00a7\3\2\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b8,\3\2\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7t\2\2\u00bb"+
		"\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7v\2\2\u00be\u00c5\7u\2\2"+
		"\u00bf\u00c0\7R\2\2\u00c0\u00c1\7T\2\2\u00c1\u00c2\7K\2\2\u00c2\u00c3"+
		"\7P\2\2\u00c3\u00c5\7V\2\2\u00c4\u00b9\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c5"+
		".\3\2\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7k\2\2\u00c9"+
		"\u00ca\7p\2\2\u00ca\u00d1\7v\2\2\u00cb\u00cc\7R\2\2\u00cc\u00cd\7T\2\2"+
		"\u00cd\u00ce\7K\2\2\u00ce\u00cf\7P\2\2\u00cf\u00d1\7V\2\2\u00d0\u00c6"+
		"\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\60\3\2\2\2\u00d2\u00d3\7k\2\2\u00d3"+
		"\u00d4\7p\2\2\u00d4\u00e4\7v\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7p\2\2"+
		"\u00d7\u00d8\7v\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7i\2\2\u00da\u00db"+
		"\7g\2\2\u00db\u00e4\7t\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7P\2\2\u00de"+
		"\u00df\7V\2\2\u00df\u00e0\7G\2\2\u00e0\u00e1\7I\2\2\u00e1\u00e2\7G\2\2"+
		"\u00e2\u00e4\7T\2\2\u00e3\u00d2\3\2\2\2\u00e3\u00d5\3\2\2\2\u00e3\u00dc"+
		"\3\2\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7n\2\2\u00e7"+
		"\u00e8\7q\2\2\u00e8\u00e9\7c\2\2\u00e9\u00f0\7v\2\2\u00ea\u00eb\7H\2\2"+
		"\u00eb\u00ec\7N\2\2\u00ec\u00ed\7Q\2\2\u00ed\u00ee\7C\2\2\u00ee\u00f0"+
		"\7V\2\2\u00ef\u00e5\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0\64\3\2\2\2\u00f1"+
		"\u00f2\7$\2\2\u00f2\66\3\2\2\2\u00f3\u00f5\7$\2\2\u00f4\u00f6\t\5\2\2"+
		"\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7$\2\2\u00fa8\3\2\2\2\u00fb\u00fc"+
		"\7U\2\2\u00fc\u00fd\7V\2\2\u00fd\u00fe\7T\2\2\u00fe\u00ff\7K\2\2\u00ff"+
		"\u0100\7P\2\2\u0100\u0108\7I\2\2\u0101\u0102\7u\2\2\u0102\u0103\7v\2\2"+
		"\u0103\u0104\7t\2\2\u0104\u0105\7k\2\2\u0105\u0106\7p\2\2\u0106\u0108"+
		"\7i\2\2\u0107\u00fb\3\2\2\2\u0107\u0101\3\2\2\2\u0108:\3\2\2\2\u0109\u010a"+
		"\7K\2\2\u010a\u010e\7H\2\2\u010b\u010c\7k\2\2\u010c\u010e\7h\2\2\u010d"+
		"\u0109\3\2\2\2\u010d\u010b\3\2\2\2\u010e<\3\2\2\2\u010f\u0110\7G\2\2\u0110"+
		"\u0111\7N\2\2\u0111\u0112\7U\2\2\u0112\u0118\7G\2\2\u0113\u0114\7g\2\2"+
		"\u0114\u0115\7n\2\2\u0115\u0116\7u\2\2\u0116\u0118\7g\2\2\u0117\u010f"+
		"\3\2\2\2\u0117\u0113\3\2\2\2\u0118>\3\2\2\2\u0119\u011a\7H\2\2\u011a\u011b"+
		"\7Q\2\2\u011b\u0120\7T\2\2\u011c\u011d\7h\2\2\u011d\u011e\7q\2\2\u011e"+
		"\u0120\7t\2\2\u011f\u0119\3\2\2\2\u011f\u011c\3\2\2\2\u0120@\3\2\2\2\u0121"+
		"\u0122\7@\2\2\u0122B\3\2\2\2\u0123\u0124\7>\2\2\u0124D\3\2\2\2\u0125\u0126"+
		"\7@\2\2\u0126\u0127\7?\2\2\u0127F\3\2\2\2\u0128\u0129\7>\2\2\u0129\u012a"+
		"\7?\2\2\u012aH\3\2\2\2\u012b\u012c\7?\2\2\u012c\u012d\7?\2\2\u012dJ\3"+
		"\2\2\2\u012e\u012f\7.\2\2\u012fL\3\2\2\2\u0130\u0131\7g\2\2\u0131\u0132"+
		"\7p\2\2\u0132\u0133\7f\2\2\u0133\u0134\7h\2\2\u0134\u0135\7w\2\2\u0135"+
		"\u0136\7p\2\2\u0136\u0137\7e\2\2\u0137\u0138\7v\2\2\u0138\u0139\7k\2\2"+
		"\u0139\u013a\7q\2\2\u013a\u0147\7p\2\2\u013b\u013c\7G\2\2\u013c\u013d"+
		"\7P\2\2\u013d\u013e\7F\2\2\u013e\u013f\7H\2\2\u013f\u0140\7W\2\2\u0140"+
		"\u0141\7P\2\2\u0141\u0142\7E\2\2\u0142\u0143\7V\2\2\u0143\u0144\7K\2\2"+
		"\u0144\u0145\7Q\2\2\u0145\u0147\7P\2\2\u0146\u0130\3\2\2\2\u0146\u013b"+
		"\3\2\2\2\u0147N\3\2\2\2\u0148\u0149\7i\2\2\u0149\u014a\7n\2\2\u014a\u014b"+
		"\7q\2\2\u014b\u014c\7d\2\2\u014c\u014d\7c\2\2\u014d\u0155\7n\2\2\u014e"+
		"\u014f\7I\2\2\u014f\u0150\7N\2\2\u0150\u0151\7Q\2\2\u0151\u0152\7D\2\2"+
		"\u0152\u0153\7C\2\2\u0153\u0155\7N\2\2\u0154\u0148\3\2\2\2\u0154\u014e"+
		"\3\2\2\2\u0155P\3\2\2\2\u0156\u0157\7T\2\2\u0157\u0158\7G\2\2\u0158\u0159"+
		"\7R\2\2\u0159\u015a\7G\2\2\u015a\u015b\7C\2\2\u015b\u0163\7V\2\2\u015c"+
		"\u015d\7t\2\2\u015d\u015e\7g\2\2\u015e\u015f\7r\2\2\u015f\u0160\7g\2\2"+
		"\u0160\u0161\7c\2\2\u0161\u0163\7v\2\2\u0162\u0156\3\2\2\2\u0162\u015c"+
		"\3\2\2\2\u0163R\3\2\2\2\u0164\u0165\7g\2\2\u0165\u0166\7p\2\2\u0166\u0167"+
		"\7f\2\2\u0167\u0168\7t\2\2\u0168\u0169\7g\2\2\u0169\u016a\7r\2\2\u016a"+
		"\u016b\7g\2\2\u016b\u016c\7c\2\2\u016c\u0177\7v\2\2\u016d\u016e\7G\2\2"+
		"\u016e\u016f\7P\2\2\u016f\u0170\7F\2\2\u0170\u0171\7T\2\2\u0171\u0172"+
		"\7G\2\2\u0172\u0173\7R\2\2\u0173\u0174\7G\2\2\u0174\u0175\7C\2\2\u0175"+
		"\u0177\7V\2\2\u0176\u0164\3\2\2\2\u0176\u016d\3\2\2\2\u0177T\3\2\2\2\u0178"+
		"\u0179\7G\2\2\u0179\u017a\7P\2\2\u017a\u017b\7F\2\2\u017b\u017c\7K\2\2"+
		"\u017c\u0183\7H\2\2\u017d\u017e\7g\2\2\u017e\u017f\7p\2\2\u017f\u0180"+
		"\7f\2\2\u0180\u0181\7k\2\2\u0181\u0183\7h\2\2\u0182\u0178\3\2\2\2\u0182"+
		"\u017d\3\2\2\2\u0183V\3\2\2\2\u0184\u0185\7h\2\2\u0185\u0186\7w\2\2\u0186"+
		"\u0187\7p\2\2\u0187\u0188\7e\2\2\u0188\u0189\7v\2\2\u0189\u018a\7k\2\2"+
		"\u018a\u018b\7q\2\2\u018b\u0195\7p\2\2\u018c\u018d\7H\2\2\u018d\u018e"+
		"\7W\2\2\u018e\u018f\7P\2\2\u018f\u0190\7E\2\2\u0190\u0191\7V\2\2\u0191"+
		"\u0192\7K\2\2\u0192\u0193\7Q\2\2\u0193\u0195\7P\2\2\u0194\u0184\3\2\2"+
		"\2\u0194\u018c\3\2\2\2\u0195X\3\2\2\2\u0196\u0197\7X\2\2\u0197\u0198\7"+
		"Q\2\2\u0198\u0199\7K\2\2\u0199\u019f\7F\2\2\u019a\u019b\7x\2\2\u019b\u019c"+
		"\7q\2\2\u019c\u019d\7k\2\2\u019d\u019f\7f\2\2\u019e\u0196\3\2\2\2\u019e"+
		"\u019a\3\2\2\2\u019fZ\3\2\2\2\u01a0\u01a2\t\6\2\2\u01a1\u01a0\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5"+
		"\3\2\2\2\u01a5\u01a6\b.\2\2\u01a6\\\3\2\2\2\u01a7\u01a8\7\61\2\2\u01a8"+
		"\u01a9\7,\2\2\u01a9\u01ad\3\2\2\2\u01aa\u01ac\13\2\2\2\u01ab\u01aa\3\2"+
		"\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae"+
		"\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7,\2\2\u01b1\u01b2\7\61"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\b/\3\2\u01b4^\3\2\2\2\u01b5\u01b6"+
		"\7\61\2\2\u01b6\u01b7\7\61\2\2\u01b7\u01bb\3\2\2\2\u01b8\u01ba\n\7\2\2"+
		"\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\b\60\4\2"+
		"\u01bf`\3\2\2\2\32\2{\u00a5\u00b7\u00c4\u00d0\u00e3\u00ef\u00f5\u00f7"+
		"\u0107\u010d\u0117\u011f\u0146\u0154\u0162\u0176\u0182\u0194\u019e\u01a3"+
		"\u01ad\u01bb";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}