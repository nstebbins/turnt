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
		RULE_prgm = 0, RULE_start = 1, RULE_body = 2, RULE_method = 3, RULE_block = 4, 
		RULE_line = 5, RULE_ifstmt = 6, RULE_sstmt = 7, RULE_estmt = 8, RULE_istmt = 9, 
		RULE_astmt = 10, RULE_fstmt = 11, RULE_file = 12, RULE_bexpr = 13, RULE_expr = 14, 
		RULE_aexpr = 15, RULE_assign = 16, RULE_type = 17;
	public static final String[] ruleNames = {
		"prgm", "start", "body", "method", "block", "line", "ifstmt", "sstmt", 
		"estmt", "istmt", "astmt", "fstmt", "file", "bexpr", "expr", "aexpr", 
		"assign", "type"
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
			setState(44);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				start();
				setState(37);
				body();
				}
				break;
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				body();
				setState(40);
				start();
				setState(41);
				body();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
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
			setState(46);
			match(T__0);
			setState(47);
			match(ID);
			setState(48);
			match(T__1);
			setState(49);
			match(T__2);
			setState(51);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(50);
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
			setState(53);
			method();
			setState(55);
			_la = _input.LA(1);
			if (_la==T__3 || _la==T__6) {
				{
				setState(54);
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(turntTestParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 6, RULE_method);
		try {
			setState(69);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__3);
				setState(58);
				match(ID);
				setState(59);
				match(T__4);
				setState(60);
				block();
				setState(61);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__6);
				setState(64);
				match(ID);
				setState(65);
				match(T__4);
				setState(66);
				block();
				setState(67);
				match(T__5);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			setState(88);
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
				setState(71);
				line();
				setState(73);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << ID))) != 0)) {
					{
					setState(72);
					block();
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__7);
				setState(76);
				fstmt();
				setState(77);
				match(T__4);
				setState(78);
				block();
				setState(79);
				match(T__5);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(T__8);
				setState(82);
				bexpr(0);
				setState(83);
				match(T__4);
				setState(84);
				block();
				setState(85);
				match(T__5);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
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
		enterRule(_localctx, 10, RULE_line);
		try {
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__9);
				setState(91);
				match(ID);
				setState(92);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__10);
				setState(94);
				match(String);
				setState(95);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(T__11);
				setState(97);
				match(ID);
				setState(98);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(T__0);
				setState(100);
				match(ID);
				setState(101);
				match(ID);
				setState(102);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				sstmt();
				setState(104);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				estmt();
				setState(107);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				istmt();
				setState(110);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(112);
				astmt();
				setState(113);
				match(T__2);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(115);
				assign();
				setState(116);
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
		enterRule(_localctx, 12, RULE_ifstmt);
		try {
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(T__12);
				setState(121);
				bexpr(0);
				setState(122);
				match(T__4);
				setState(123);
				block();
				setState(124);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
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
				setState(131);
				match(T__13);
				setState(132);
				match(T__4);
				setState(133);
				block();
				setState(134);
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
		enterRule(_localctx, 14, RULE_sstmt);
		try {
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__14);
				setState(139);
				type();
				setState(140);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(T__14);
				setState(143);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(T__14);
				setState(145);
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
		enterRule(_localctx, 16, RULE_estmt);
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(T__15);
				setState(149);
				match(ID);
				setState(150);
				match(T__16);
				setState(151);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(T__15);
				setState(153);
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
		enterRule(_localctx, 18, RULE_istmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__17);
			setState(157);
			match(ID);
			setState(158);
			match(T__18);
			setState(159);
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
		enterRule(_localctx, 20, RULE_astmt);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(T__6);
				setState(162);
				match(ID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
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
		enterRule(_localctx, 22, RULE_fstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__19);
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(167);
				aexpr(0);
				}
				break;
			case 2:
				{
				setState(168);
				assign();
				}
				break;
			}
			setState(171);
			match(T__2);
			setState(172);
			bexpr(0);
			setState(173);
			match(T__2);
			setState(174);
			assign();
			setState(175);
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
		enterRule(_localctx, 24, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ID);
			setState(178);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(181);
				match(T__22);
				setState(182);
				bexpr(4);
				}
				break;
			case 2:
				{
				setState(183);
				expr();
				setState(184);
				match(RELOP);
				setState(185);
				expr();
				}
				break;
			case 3:
				{
				setState(187);
				match(T__19);
				setState(188);
				bexpr(0);
				setState(189);
				match(T__20);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(193);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(194);
						match(T__23);
						setState(195);
						bexpr(4);
						}
						break;
					case 2:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(196);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(197);
						match(T__24);
						setState(198);
						bexpr(3);
						}
						break;
					}
					} 
				}
				setState(203);
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
		enterRule(_localctx, 28, RULE_expr);
		try {
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				aexpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(T__19);
				setState(206);
				expr();
				setState(207);
				match(T__20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(Number);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(210);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_aexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			switch (_input.LA(1)) {
			case T__25:
				{
				setState(214);
				match(T__25);
				setState(215);
				match(T__19);
				setState(216);
				aexpr(0);
				setState(217);
				match(OP);
				setState(218);
				aexpr(0);
				setState(219);
				match(T__20);
				}
				break;
			case T__19:
				{
				setState(221);
				match(T__19);
				setState(222);
				aexpr(0);
				setState(223);
				match(T__20);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(232);
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
					setState(227);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(228);
					match(OP);
					setState(229);
					aexpr(4);
					}
					} 
				}
				setState(234);
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
		enterRule(_localctx, 32, RULE_assign);
		try {
			setState(247);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				type();
				setState(236);
				match(ID);
				setState(237);
				match(T__26);
				setState(238);
				expr();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(ID);
				setState(241);
				match(T__26);
				setState(242);
				expr();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				match(T__19);
				setState(244);
				assign();
				setState(245);
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
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
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
		case 13:
			return bexpr_sempred((BexprContext)_localctx, predIndex);
		case 15:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u00fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2/\n\2\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\66\n\3\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5H\n\5\3\6\3\6\5\6L\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u008b\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0095\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u009d\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5"+
		"\f\u00a7\n\f\3\r\3\r\3\r\5\r\u00ac\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c2"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ca\n\17\f\17\16\17\u00cd\13"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d6\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e4\n\21\3\21\3\21"+
		"\3\21\7\21\u00e9\n\21\f\21\16\21\u00ec\13\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fa\n\22\3\23\3\23\3\23\2\4"+
		"\34 \24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\36#\u010d\2"+
		".\3\2\2\2\4\60\3\2\2\2\6\67\3\2\2\2\bG\3\2\2\2\nZ\3\2\2\2\fx\3\2\2\2\16"+
		"\u008a\3\2\2\2\20\u0094\3\2\2\2\22\u009c\3\2\2\2\24\u009e\3\2\2\2\26\u00a6"+
		"\3\2\2\2\30\u00a8\3\2\2\2\32\u00b3\3\2\2\2\34\u00c1\3\2\2\2\36\u00d5\3"+
		"\2\2\2 \u00e3\3\2\2\2\"\u00f9\3\2\2\2$\u00fb\3\2\2\2&\'\5\4\3\2\'(\5\6"+
		"\4\2(/\3\2\2\2)*\5\6\4\2*+\5\4\3\2+,\5\6\4\2,/\3\2\2\2-/\7\2\2\3.&\3\2"+
		"\2\2.)\3\2\2\2.-\3\2\2\2/\3\3\2\2\2\60\61\7\3\2\2\61\62\7+\2\2\62\63\7"+
		"\4\2\2\63\65\7\5\2\2\64\66\5\4\3\2\65\64\3\2\2\2\65\66\3\2\2\2\66\5\3"+
		"\2\2\2\679\5\b\5\28:\5\6\4\298\3\2\2\29:\3\2\2\2:\7\3\2\2\2;<\7\6\2\2"+
		"<=\7+\2\2=>\7\7\2\2>?\5\n\6\2?@\7\b\2\2@H\3\2\2\2AB\7\t\2\2BC\7+\2\2C"+
		"D\7\7\2\2DE\5\n\6\2EF\7\b\2\2FH\3\2\2\2G;\3\2\2\2GA\3\2\2\2H\t\3\2\2\2"+
		"IK\5\f\7\2JL\5\n\6\2KJ\3\2\2\2KL\3\2\2\2L[\3\2\2\2MN\7\n\2\2NO\5\30\r"+
		"\2OP\7\7\2\2PQ\5\n\6\2QR\7\b\2\2R[\3\2\2\2ST\7\13\2\2TU\5\34\17\2UV\7"+
		"\7\2\2VW\5\n\6\2WX\7\b\2\2X[\3\2\2\2Y[\5\16\b\2ZI\3\2\2\2ZM\3\2\2\2ZS"+
		"\3\2\2\2ZY\3\2\2\2[\13\3\2\2\2\\]\7\f\2\2]^\7+\2\2^y\7\5\2\2_`\7\r\2\2"+
		"`a\7$\2\2ay\7\5\2\2bc\7\16\2\2cd\7+\2\2dy\7\5\2\2ef\7\3\2\2fg\7+\2\2g"+
		"h\7+\2\2hy\7\5\2\2ij\5\20\t\2jk\7\5\2\2ky\3\2\2\2lm\5\22\n\2mn\7\5\2\2"+
		"ny\3\2\2\2op\5\24\13\2pq\7\5\2\2qy\3\2\2\2rs\5\26\f\2st\7\5\2\2ty\3\2"+
		"\2\2uv\5\"\22\2vw\7\5\2\2wy\3\2\2\2x\\\3\2\2\2x_\3\2\2\2xb\3\2\2\2xe\3"+
		"\2\2\2xi\3\2\2\2xl\3\2\2\2xo\3\2\2\2xr\3\2\2\2xu\3\2\2\2y\r\3\2\2\2z{"+
		"\7\17\2\2{|\5\34\17\2|}\7\7\2\2}~\5\n\6\2~\177\7\b\2\2\177\u008b\3\2\2"+
		"\2\u0080\u0081\7\17\2\2\u0081\u0082\5\34\17\2\u0082\u0083\7\7\2\2\u0083"+
		"\u0084\5\n\6\2\u0084\u0085\7\b\2\2\u0085\u0086\7\20\2\2\u0086\u0087\7"+
		"\7\2\2\u0087\u0088\5\n\6\2\u0088\u0089\7\b\2\2\u0089\u008b\3\2\2\2\u008a"+
		"z\3\2\2\2\u008a\u0080\3\2\2\2\u008b\17\3\2\2\2\u008c\u008d\7\21\2\2\u008d"+
		"\u008e\5$\23\2\u008e\u008f\7+\2\2\u008f\u0095\3\2\2\2\u0090\u0091\7\21"+
		"\2\2\u0091\u0095\7+\2\2\u0092\u0093\7\21\2\2\u0093\u0095\5\"\22\2\u0094"+
		"\u008c\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0092\3\2\2\2\u0095\21\3\2\2"+
		"\2\u0096\u0097\7\22\2\2\u0097\u0098\7+\2\2\u0098\u0099\7\23\2\2\u0099"+
		"\u009d\7+\2\2\u009a\u009b\7\22\2\2\u009b\u009d\7+\2\2\u009c\u0096\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009d\23\3\2\2\2\u009e\u009f\7\24\2\2\u009f\u00a0"+
		"\7+\2\2\u00a0\u00a1\7\25\2\2\u00a1\u00a2\5\32\16\2\u00a2\25\3\2\2\2\u00a3"+
		"\u00a4\7\t\2\2\u00a4\u00a7\7+\2\2\u00a5\u00a7\7+\2\2\u00a6\u00a3\3\2\2"+
		"\2\u00a6\u00a5\3\2\2\2\u00a7\27\3\2\2\2\u00a8\u00ab\7\26\2\2\u00a9\u00ac"+
		"\5 \21\2\u00aa\u00ac\5\"\22\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\5\2\2\u00ae\u00af\5\34\17\2\u00af\u00b0"+
		"\7\5\2\2\u00b0\u00b1\5\"\22\2\u00b1\u00b2\7\27\2\2\u00b2\31\3\2\2\2\u00b3"+
		"\u00b4\7+\2\2\u00b4\u00b5\7\30\2\2\u00b5\33\3\2\2\2\u00b6\u00b7\b\17\1"+
		"\2\u00b7\u00b8\7\31\2\2\u00b8\u00c2\5\34\17\6\u00b9\u00ba\5\36\20\2\u00ba"+
		"\u00bb\7(\2\2\u00bb\u00bc\5\36\20\2\u00bc\u00c2\3\2\2\2\u00bd\u00be\7"+
		"\26\2\2\u00be\u00bf\5\34\17\2\u00bf\u00c0\7\27\2\2\u00c0\u00c2\3\2\2\2"+
		"\u00c1\u00b6\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c2\u00cb"+
		"\3\2\2\2\u00c3\u00c4\f\5\2\2\u00c4\u00c5\7\32\2\2\u00c5\u00ca\5\34\17"+
		"\6\u00c6\u00c7\f\4\2\2\u00c7\u00c8\7\33\2\2\u00c8\u00ca\5\34\17\5\u00c9"+
		"\u00c3\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\35\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d6"+
		"\5 \21\2\u00cf\u00d0\7\26\2\2\u00d0\u00d1\5\36\20\2\u00d1\u00d2\7\27\2"+
		"\2\u00d2\u00d6\3\2\2\2\u00d3\u00d6\7%\2\2\u00d4\u00d6\7+\2\2\u00d5\u00ce"+
		"\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\37\3\2\2\2\u00d7\u00d8\b\21\1\2\u00d8\u00d9\7\34\2\2\u00d9\u00da\7\26"+
		"\2\2\u00da\u00db\5 \21\2\u00db\u00dc\7)\2\2\u00dc\u00dd\5 \21\2\u00dd"+
		"\u00de\7\27\2\2\u00de\u00e4\3\2\2\2\u00df\u00e0\7\26\2\2\u00e0\u00e1\5"+
		" \21\2\u00e1\u00e2\7\27\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d7\3\2\2\2\u00e3"+
		"\u00df\3\2\2\2\u00e4\u00ea\3\2\2\2\u00e5\u00e6\f\5\2\2\u00e6\u00e7\7)"+
		"\2\2\u00e7\u00e9\5 \21\6\u00e8\u00e5\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb!\3\2\2\2\u00ec\u00ea\3\2\2\2"+
		"\u00ed\u00ee\5$\23\2\u00ee\u00ef\7+\2\2\u00ef\u00f0\7\35\2\2\u00f0\u00f1"+
		"\5\36\20\2\u00f1\u00fa\3\2\2\2\u00f2\u00f3\7+\2\2\u00f3\u00f4\7\35\2\2"+
		"\u00f4\u00fa\5\36\20\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\5\"\22\2\u00f7"+
		"\u00f8\7\27\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00ed\3\2\2\2\u00f9\u00f2\3"+
		"\2\2\2\u00f9\u00f5\3\2\2\2\u00fa#\3\2\2\2\u00fb\u00fc\t\2\2\2\u00fc%\3"+
		"\2\2\2\25.\659GKZx\u008a\u0094\u009c\u00a6\u00ab\u00c1\u00c9\u00cb\u00d5"+
		"\u00e3\u00ea\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}