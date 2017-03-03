package main;

import java.util.BitSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.GrammarLexer;
import grammar.GrammarParser;
import grammar.GrammarParser.ProgramContext;

public class Main {
	
	final static ANTLRErrorListener errorListener = createErrorListener(); 

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	private static ANTLRErrorListener createErrorListener() {
        return new ANTLRErrorListener() {
            public void syntaxError(final Recognizer<?, ?> arg0, final Object obj, final int line, final int position, final String message, final RecognitionException ex) {
                throw new IllegalArgumentException(String.format(Locale.ROOT, "Exception parsing expression: '%s' on line %s, position %s", message, line, position));
            }

            public void reportContextSensitivity(final Parser arg0, final DFA arg1, final int arg2, final int arg3, final int arg4, final ATNConfigSet arg5) {
            }

            public void reportAttemptingFullContext(final Parser arg0, final DFA arg1, final int arg2, final int arg3, final BitSet arg4, final ATNConfigSet arg5) {
            }

            public void reportAmbiguity(final Parser arg0, final DFA arg1, final int arg2, final int arg3, final boolean arg4, final BitSet arg5, final ATNConfigSet arg6) {
            }
        };
    }

	public static void main(String[] args) {
		
		//Test ³¹czenia plików
		String program = Loader.loadFile("test.txt");
		//System.out.println(testFile);
		
		
		GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(program));
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListener);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(errorListener);
		
		parser.setBuildParseTree(true);
		
		ProgramContext context = parser.program();
		
		
		ParseTreeWalker walker = new ParseTreeWalker();
	    GrammarListener listener = new GrammarListener();
	    walker.walk(listener, context);
	    
	    Loader.save(listener.instrStack.getInstrList(), "program.ll");
		

	}
	

	

}


