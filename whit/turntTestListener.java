// Generated from turntTest.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link turntTestParser}.
 */
public interface turntTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link turntTestParser#prgm}.
	 * @param ctx the parse tree
	 */
	void enterPrgm(turntTestParser.PrgmContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#prgm}.
	 * @param ctx the parse tree
	 */
	void exitPrgm(turntTestParser.PrgmContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(turntTestParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(turntTestParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(turntTestParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(turntTestParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#dir}.
	 * @param ctx the parse tree
	 */
	void enterDir(turntTestParser.DirContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#dir}.
	 * @param ctx the parse tree
	 */
	void exitDir(turntTestParser.DirContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(turntTestParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(turntTestParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(turntTestParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(turntTestParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(turntTestParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(turntTestParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(turntTestParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(turntTestParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(turntTestParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(turntTestParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#sstmt}.
	 * @param ctx the parse tree
	 */
	void enterSstmt(turntTestParser.SstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#sstmt}.
	 * @param ctx the parse tree
	 */
	void exitSstmt(turntTestParser.SstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#estmt}.
	 * @param ctx the parse tree
	 */
	void enterEstmt(turntTestParser.EstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#estmt}.
	 * @param ctx the parse tree
	 */
	void exitEstmt(turntTestParser.EstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#istmt}.
	 * @param ctx the parse tree
	 */
	void enterIstmt(turntTestParser.IstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#istmt}.
	 * @param ctx the parse tree
	 */
	void exitIstmt(turntTestParser.IstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#astmt}.
	 * @param ctx the parse tree
	 */
	void enterAstmt(turntTestParser.AstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#astmt}.
	 * @param ctx the parse tree
	 */
	void exitAstmt(turntTestParser.AstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#fstmt}.
	 * @param ctx the parse tree
	 */
	void enterFstmt(turntTestParser.FstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#fstmt}.
	 * @param ctx the parse tree
	 */
	void exitFstmt(turntTestParser.FstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(turntTestParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(turntTestParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(turntTestParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(turntTestParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(turntTestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(turntTestParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(turntTestParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(turntTestParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(turntTestParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(turntTestParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link turntTestParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(turntTestParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link turntTestParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(turntTestParser.TypeContext ctx);
}