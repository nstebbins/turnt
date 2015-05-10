import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.*;
//import turntToJava.*;

public class Translate {

	public static void main(String[] args) throws Exception {

		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in);

		// create a lexer that feeds off of input CharStream
		turntLexer lexer = new turntLexer(input);

		// create a buffer of tokens pulled from the lexe
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		turntParser parser = new turntParser(tokens);

		ParseTree tree = parser.prgm(); // begin parsing at init rule

		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(new translateToJava(), tree);
		System.out.println(); // print a \n after translation

		}


}
