// Generated from turntTest.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class turntTestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, String=34, Number=35, INT=36, FLOAT=37, RELOP=38, 
		OP=39, Digit=40, ID=41, WS=42;
	public static final int
		RULE_prgm = 0, RULE_start = 1, RULE_body = 2, RULE_dir = 3, RULE_action = 4, 
		RULE_method = 5, RULE_block = 6, RULE_line = 7, RULE_ifstmt = 8, RULE_sstmt = 9, 
		RULE_estmt = 10, RULE_istmt = 11, RULE_astmt = 12, RULE_fstmt = 13, RULE_file = 14, 
		RULE_bexpr = 15, RULE_expr = 16, RULE_aexpr = 17, RULE_assign = 18, RULE_type = 19;
	public static final String[] ruleNames = {
		"prgm", "start", "body", "dir", "action", "method", "block", "line", "ifstmt", 
		"sstmt", "estmt", "istmt", "astmt", "fstmt", "file", "bexpr", "expr", 
		"aexpr", "assign", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'register'", "'main'", "';'", "'dir'", "'{'", "'}'", "'action'", 
		"'for'", "'while'", "'prompt'", "'print'", "'event'", "'if'", "'else'", 
		"'state'", "'emit'", "'in'", "'module'", "'= import'", "'('", "')'", "'.tt'", 
		"'!'", "'&&'", "'||'", "'-'", "'='", "'int'", "'float'", "'bool'", "'char'", 
		"'String'", "'list'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "String", 
		"Number", "INT", "FLOAT", "RELOP", "OP", "Digit", "ID", "WS"
	};
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
	public String getGrammarFileName() { return "turntTest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public turntTestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PrgmContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode EOF() { return getToken(turntTestParser.EOF, 0); }
		public PrgmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prgm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterPrgm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitPrgm(this);
		}
	}

	public final PrgmContext prgm() throws RecognitionException {
		PrgmContext _localctx = new PrgmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prgm);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				start();
				setState(41);
				body();
				}
				break;
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				body();
				setState(44);
				start();
				setState(45);
				body();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StartContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(ID);
			setState(52);
			match(T__1);
			setState(53);
			match(T__2);
			setState(55);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(54);
				start();
				}
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

	public static class BodyContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			method();
			setState(59);
			_la = _input.LA(1);
			if (_la==T__3 || _la==T__6) {
				{
				setState(58);
				body();
				}
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

	public static class DirContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterDir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitDir(this);
		}
	}

	public final DirContext dir() throws RecognitionException {
		DirContext _localctx = new DirContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__3);
			setState(62);
			match(ID);
			setState(63);
			match(T__4);
			setState(64);
			block();
			setState(65);
			match(T__5);
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(ID);
			setState(69);
			match(T__4);
			setState(70);
			block();
			setState(71);
			match(T__5);
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

	public static class MethodContext extends ParserRuleContext {
		public DirContext dir() {
			return getRuleContext(DirContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		try {
			setState(75);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				dir();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				action();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BlockContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FstmtContext fstmt() {
			return getRuleContext(FstmtContext.class,0);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			setState(94);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__9:
			case T__10:
			case T__11:
			case T__14:
			case T__15:
			case T__17:
			case T__19:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				line();
				setState(79);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
					{
					setState(78);
					block();
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__7);
				setState(82);
				fstmt();
				setState(83);
				match(T__4);
				setState(84);
				block();
				setState(85);
				match(T__5);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(T__8);
				setState(88);
				bexpr(0);
				setState(89);
				match(T__4);
				setState(90);
				block();
				setState(91);
				match(T__5);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				ifstmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LineContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(turntTestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(turntTestParser.ID, i);
		}
		public TerminalNode String() { return getToken(turntTestParser.String, 0); }
		public SstmtContext sstmt() {
			return getRuleContext(SstmtContext.class,0);
		}
		public EstmtContext estmt() {
			return getRuleContext(EstmtContext.class,0);
		}
		public IstmtContext istmt() {
			return getRuleContext(IstmtContext.class,0);
		}
		public AstmtContext astmt() {
			return getRuleContext(AstmtContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_line);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__9);
				setState(97);
				match(ID);
				setState(98);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__10);
				setState(100);
				match(String);
				setState(101);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(T__11);
				setState(103);
				match(ID);
				setState(104);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(T__0);
				setState(106);
				match(ID);
				setState(107);
				match(ID);
				setState(108);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				sstmt();
				setState(110);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				estmt();
				setState(113);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				istmt();
				setState(116);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(118);
				astmt();
				setState(119);
				match(T__2);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(121);
				assign();
				setState(122);
				match(T__2);
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

	public static class IfstmtContext extends ParserRuleContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitIfstmt(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstmt);
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(T__12);
				setState(127);
				bexpr(0);
				setState(128);
				match(T__4);
				setState(129);
				block();
				setState(130);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(T__12);
				setState(133);
				bexpr(0);
				setState(134);
				match(T__4);
				setState(135);
				block();
				setState(136);
				match(T__5);
				setState(137);
				match(T__13);
				setState(138);
				match(T__4);
				setState(139);
				block();
				setState(140);
				match(T__5);
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

	public static class SstmtContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public SstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterSstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitSstmt(this);
		}
	}

	public final SstmtContext sstmt() throws RecognitionException {
		SstmtContext _localctx = new SstmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sstmt);
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__14);
				setState(145);
				type();
				setState(146);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__14);
				setState(149);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(T__14);
				setState(151);
				assign();
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

	public static class EstmtContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(turntTestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(turntTestParser.ID, i);
		}
		public EstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterEstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitEstmt(this);
		}
	}

	public final EstmtContext estmt() throws RecognitionException {
		EstmtContext _localctx = new EstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_estmt);
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(T__15);
				setState(155);
				match(ID);
				setState(156);
				match(T__16);
				setState(157);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__15);
				setState(159);
				match(ID);
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

	public static class IstmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public IstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_istmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterIstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitIstmt(this);
		}
	}

	public final IstmtContext istmt() throws RecognitionException {
		IstmtContext _localctx = new IstmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_istmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__17);
			setState(163);
			match(ID);
			setState(164);
			match(T__18);
			setState(165);
			file();
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

	public static class AstmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public AstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_astmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterAstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitAstmt(this);
		}
	}

	public final AstmtContext astmt() throws RecognitionException {
		AstmtContext _localctx = new AstmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_astmt);
		try {
			setState(170);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__6);
				setState(168);
				match(ID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FstmtContext extends ParserRuleContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public FstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterFstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitFstmt(this);
		}
	}

	public final FstmtContext fstmt() throws RecognitionException {
		FstmtContext _localctx = new FstmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__19);
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(173);
				aexpr(0);
				}
				break;
			case 2:
				{
				setState(174);
				assign();
				}
				break;
			}
			setState(177);
			match(T__2);
			setState(178);
			bexpr(0);
			setState(179);
			match(T__2);
			setState(180);
			assign();
			setState(181);
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

	public static class FileContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ID);
			setState(184);
			match(T__21);
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

	public static class BexprContext extends ParserRuleContext {
		public List<BexprContext> bexpr() {
			return getRuleContexts(BexprContext.class);
		}
		public BexprContext bexpr(int i) {
			return getRuleContext(BexprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(turntTestParser.RELOP, 0); }
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitBexpr(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		return bexpr(0);
	}

	private BexprContext bexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BexprContext _localctx = new BexprContext(_ctx, _parentState);
		BexprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(187);
				match(T__22);
				setState(188);
				bexpr(4);
				}
				break;
			case 2:
				{
				setState(189);
				expr();
				setState(190);
				match(RELOP);
				setState(191);
				expr();
				}
				break;
			case 3:
				{
				setState(193);
				match(T__19);
				setState(194);
				bexpr(0);
				setState(195);
				match(T__20);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(199);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(200);
						match(T__23);
						setState(201);
						bexpr(4);
						}
						break;
					case 2:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(202);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(203);
						match(T__24);
						setState(204);
						bexpr(3);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Number() { return getToken(turntTestParser.Number, 0); }
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				aexpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(T__19);
				setState(212);
				expr();
				setState(213);
				match(T__20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(Number);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(ID);
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

	public static class AexprContext extends ParserRuleContext {
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public TerminalNode OP() { return getToken(turntTestParser.OP, 0); }
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitAexpr(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		return aexpr(0);
	}

	private AexprContext aexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexprContext _localctx = new AexprContext(_ctx, _parentState);
		AexprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_aexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(220);
				match(T__25);
				setState(221);
				match(T__19);
				setState(222);
				aexpr(0);
				setState(223);
				match(OP);
				setState(224);
				aexpr(0);
				setState(225);
				match(T__20);
				}
				break;
			case T__19:
				{
				setState(227);
				match(T__19);
				setState(228);
				aexpr(0);
				setState(229);
				match(T__20);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_aexpr);
					setState(233);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(234);
					match(OP);
					setState(235);
					aexpr(4);
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class AssignContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign);
		try {
			setState(253);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				type();
				setState(242);
				match(ID);
				setState(243);
				match(T__26);
				setState(244);
				expr();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(ID);
				setState(247);
				match(T__26);
				setState(248);
				expr();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(T__19);
				setState(250);
				assign();
				setState(251);
				match(T__20);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof turntTestListener ) ((turntTestListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return bexpr_sempred((BexprContext)_localctx, predIndex);
		case 17:
			return aexpr_sempred((AexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bexpr_sempred(BexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean aexpr_sempred(AexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u0104\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\63"+
		"\n\2\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7N\n\7\3\b\3\b\5\bR\n\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\ba\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u009b\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00ad\n\16\3\17\3\17\3\17\5\17"+
		"\u00b2\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00c8\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00d0\n\21\f\21\16\21\u00d3\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00dc\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00ea\n\23\3\23\3\23\3\23\7\23\u00ef\n"+
		"\23\f\23\16\23\u00f2\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0100\n\24\3\25\3\25\3\25\2\4 $\26\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(\2\3\3\2\36#\u0111\2\62\3\2\2\2\4\64\3\2"+
		"\2\2\6;\3\2\2\2\b?\3\2\2\2\nE\3\2\2\2\fM\3\2\2\2\16`\3\2\2\2\20~\3\2\2"+
		"\2\22\u0090\3\2\2\2\24\u009a\3\2\2\2\26\u00a2\3\2\2\2\30\u00a4\3\2\2\2"+
		"\32\u00ac\3\2\2\2\34\u00ae\3\2\2\2\36\u00b9\3\2\2\2 \u00c7\3\2\2\2\"\u00db"+
		"\3\2\2\2$\u00e9\3\2\2\2&\u00ff\3\2\2\2(\u0101\3\2\2\2*+\5\4\3\2+,\5\6"+
		"\4\2,\63\3\2\2\2-.\5\6\4\2./\5\4\3\2/\60\5\6\4\2\60\63\3\2\2\2\61\63\7"+
		"\2\2\3\62*\3\2\2\2\62-\3\2\2\2\62\61\3\2\2\2\63\3\3\2\2\2\64\65\7\3\2"+
		"\2\65\66\7+\2\2\66\67\7\4\2\2\679\7\5\2\28:\5\4\3\298\3\2\2\29:\3\2\2"+
		"\2:\5\3\2\2\2;=\5\f\7\2<>\5\6\4\2=<\3\2\2\2=>\3\2\2\2>\7\3\2\2\2?@\7\6"+
		"\2\2@A\7+\2\2AB\7\7\2\2BC\5\16\b\2CD\7\b\2\2D\t\3\2\2\2EF\7\t\2\2FG\7"+
		"+\2\2GH\7\7\2\2HI\5\16\b\2IJ\7\b\2\2J\13\3\2\2\2KN\5\b\5\2LN\5\n\6\2M"+
		"K\3\2\2\2ML\3\2\2\2N\r\3\2\2\2OQ\5\20\t\2PR\5\16\b\2QP\3\2\2\2QR\3\2\2"+
		"\2Ra\3\2\2\2ST\7\n\2\2TU\5\34\17\2UV\7\7\2\2VW\5\16\b\2WX\7\b\2\2Xa\3"+
		"\2\2\2YZ\7\13\2\2Z[\5 \21\2[\\\7\7\2\2\\]\5\16\b\2]^\7\b\2\2^a\3\2\2\2"+
		"_a\5\22\n\2`O\3\2\2\2`S\3\2\2\2`Y\3\2\2\2`_\3\2\2\2a\17\3\2\2\2bc\7\f"+
		"\2\2cd\7+\2\2d\177\7\5\2\2ef\7\r\2\2fg\7$\2\2g\177\7\5\2\2hi\7\16\2\2"+
		"ij\7+\2\2j\177\7\5\2\2kl\7\3\2\2lm\7+\2\2mn\7+\2\2n\177\7\5\2\2op\5\24"+
		"\13\2pq\7\5\2\2q\177\3\2\2\2rs\5\26\f\2st\7\5\2\2t\177\3\2\2\2uv\5\30"+
		"\r\2vw\7\5\2\2w\177\3\2\2\2xy\5\32\16\2yz\7\5\2\2z\177\3\2\2\2{|\5&\24"+
		"\2|}\7\5\2\2}\177\3\2\2\2~b\3\2\2\2~e\3\2\2\2~h\3\2\2\2~k\3\2\2\2~o\3"+
		"\2\2\2~r\3\2\2\2~u\3\2\2\2~x\3\2\2\2~{\3\2\2\2\177\21\3\2\2\2\u0080\u0081"+
		"\7\17\2\2\u0081\u0082\5 \21\2\u0082\u0083\7\7\2\2\u0083\u0084\5\16\b\2"+
		"\u0084\u0085\7\b\2\2\u0085\u0091\3\2\2\2\u0086\u0087\7\17\2\2\u0087\u0088"+
		"\5 \21\2\u0088\u0089\7\7\2\2\u0089\u008a\5\16\b\2\u008a\u008b\7\b\2\2"+
		"\u008b\u008c\7\20\2\2\u008c\u008d\7\7\2\2\u008d\u008e\5\16\b\2\u008e\u008f"+
		"\7\b\2\2\u008f\u0091\3\2\2\2\u0090\u0080\3\2\2\2\u0090\u0086\3\2\2\2\u0091"+
		"\23\3\2\2\2\u0092\u0093\7\21\2\2\u0093\u0094\5(\25\2\u0094\u0095\7+\2"+
		"\2\u0095\u009b\3\2\2\2\u0096\u0097\7\21\2\2\u0097\u009b\7+\2\2\u0098\u0099"+
		"\7\21\2\2\u0099\u009b\5&\24\2\u009a\u0092\3\2\2\2\u009a\u0096\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009b\25\3\2\2\2\u009c\u009d\7\22\2\2\u009d\u009e"+
		"\7+\2\2\u009e\u009f\7\23\2\2\u009f\u00a3\7+\2\2\u00a0\u00a1\7\22\2\2\u00a1"+
		"\u00a3\7+\2\2\u00a2\u009c\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\27\3\2\2\2"+
		"\u00a4\u00a5\7\24\2\2\u00a5\u00a6\7+\2\2\u00a6\u00a7\7\25\2\2\u00a7\u00a8"+
		"\5\36\20\2\u00a8\31\3\2\2\2\u00a9\u00aa\7\t\2\2\u00aa\u00ad\7+\2\2\u00ab"+
		"\u00ad\7+\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\33\3\2\2\2"+
		"\u00ae\u00b1\7\26\2\2\u00af\u00b2\5$\23\2\u00b0\u00b2\5&\24\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\5\2\2\u00b4"+
		"\u00b5\5 \21\2\u00b5\u00b6\7\5\2\2\u00b6\u00b7\5&\24\2\u00b7\u00b8\7\27"+
		"\2\2\u00b8\35\3\2\2\2\u00b9\u00ba\7+\2\2\u00ba\u00bb\7\30\2\2\u00bb\37"+
		"\3\2\2\2\u00bc\u00bd\b\21\1\2\u00bd\u00be\7\31\2\2\u00be\u00c8\5 \21\6"+
		"\u00bf\u00c0\5\"\22\2\u00c0\u00c1\7(\2\2\u00c1\u00c2\5\"\22\2\u00c2\u00c8"+
		"\3\2\2\2\u00c3\u00c4\7\26\2\2\u00c4\u00c5\5 \21\2\u00c5\u00c6\7\27\2\2"+
		"\u00c6\u00c8\3\2\2\2\u00c7\u00bc\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3"+
		"\3\2\2\2\u00c8\u00d1\3\2\2\2\u00c9\u00ca\f\5\2\2\u00ca\u00cb\7\32\2\2"+
		"\u00cb\u00d0\5 \21\6\u00cc\u00cd\f\4\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00d0"+
		"\5 \21\5\u00cf\u00c9\3\2\2\2\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2!\3\2\2\2\u00d3\u00d1\3\2\2\2"+
		"\u00d4\u00dc\5$\23\2\u00d5\u00d6\7\26\2\2\u00d6\u00d7\5\"\22\2\u00d7\u00d8"+
		"\7\27\2\2\u00d8\u00dc\3\2\2\2\u00d9\u00dc\7%\2\2\u00da\u00dc\7+\2\2\u00db"+
		"\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2"+
		"\2\2\u00dc#\3\2\2\2\u00dd\u00de\b\23\1\2\u00de\u00df\7\34\2\2\u00df\u00e0"+
		"\7\26\2\2\u00e0\u00e1\5$\23\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\5$\23\2\u00e3"+
		"\u00e4\7\27\2\2\u00e4\u00ea\3\2\2\2\u00e5\u00e6\7\26\2\2\u00e6\u00e7\5"+
		"$\23\2\u00e7\u00e8\7\27\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00dd\3\2\2\2\u00e9"+
		"\u00e5\3\2\2\2\u00ea\u00f0\3\2\2\2\u00eb\u00ec\f\5\2\2\u00ec\u00ed\7)"+
		"\2\2\u00ed\u00ef\5$\23\6\u00ee\u00eb\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1%\3\2\2\2\u00f2\u00f0\3\2\2\2"+
		"\u00f3\u00f4\5(\25\2\u00f4\u00f5\7+\2\2\u00f5\u00f6\7\35\2\2\u00f6\u00f7"+
		"\5\"\22\2\u00f7\u0100\3\2\2\2\u00f8\u00f9\7+\2\2\u00f9\u00fa\7\35\2\2"+
		"\u00fa\u0100\5\"\22\2\u00fb\u00fc\7\26\2\2\u00fc\u00fd\5&\24\2\u00fd\u00fe"+
		"\7\27\2\2\u00fe\u0100\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff\u00f8\3\2\2\2"+
		"\u00ff\u00fb\3\2\2\2\u0100\'\3\2\2\2\u0101\u0102\t\2\2\2\u0102)\3\2\2"+
		"\2\25\629=MQ`~\u0090\u009a\u00a2\u00ac\u00b1\u00c7\u00cf\u00d1\u00db\u00e9"+
		"\u00f0\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}