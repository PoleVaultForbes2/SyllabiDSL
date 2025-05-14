// Generated from T:/Documents/DSL/src/SyllabusDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SyllabusDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, DATE=13, COLOR=14, ID=15, STRING=16, INT=17, 
		WS=18, INVALID=19;
	public static final int
		RULE_syllabus = 0, RULE_breaks = 1, RULE_breakRange = 2, RULE_semesterDates = 3, 
		RULE_difficultyLevels = 4, RULE_difficultyEntry = 5, RULE_course = 6, 
		RULE_category = 7, RULE_assignment = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"syllabus", "breaks", "breakRange", "semesterDates", "difficultyLevels", 
			"difficultyEntry", "course", "category", "assignment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BREAKS'", "':'", "'('", "'-'", "')'", "'SEMESTER DATES'", "','", 
			"'DIFFICULTY LEVEL:'", "'COURSE'", "'HOMEWORK'", "'PROJECTS'", "'TEST'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "DATE", "COLOR", "ID", "STRING", "INT", "WS", "INVALID"
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
	public String getGrammarFileName() { return "SyllabusDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SyllabusDSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SyllabusContext extends ParserRuleContext {
		public DifficultyLevelsContext difficultyLevels() {
			return getRuleContext(DifficultyLevelsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SyllabusDSLParser.EOF, 0); }
		public BreaksContext breaks() {
			return getRuleContext(BreaksContext.class,0);
		}
		public SemesterDatesContext semesterDates() {
			return getRuleContext(SemesterDatesContext.class,0);
		}
		public List<CourseContext> course() {
			return getRuleContexts(CourseContext.class);
		}
		public CourseContext course(int i) {
			return getRuleContext(CourseContext.class,i);
		}
		public SyllabusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syllabus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterSyllabus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitSyllabus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitSyllabus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyllabusContext syllabus() throws RecognitionException {
		SyllabusContext _localctx = new SyllabusContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_syllabus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			difficultyLevels();
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(19);
				breaks();
				}
			}

			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(22);
				semesterDates();
				}
			}

			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				course();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 );
			setState(30);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreaksContext extends ParserRuleContext {
		public List<BreakRangeContext> breakRange() {
			return getRuleContexts(BreakRangeContext.class);
		}
		public BreakRangeContext breakRange(int i) {
			return getRuleContext(BreakRangeContext.class,i);
		}
		public BreaksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breaks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterBreaks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitBreaks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitBreaks(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreaksContext breaks() throws RecognitionException {
		BreaksContext _localctx = new BreaksContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_breaks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(T__1);
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				breakRange();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakRangeContext extends ParserRuleContext {
		public List<TerminalNode> DATE() { return getTokens(SyllabusDSLParser.DATE); }
		public TerminalNode DATE(int i) {
			return getToken(SyllabusDSLParser.DATE, i);
		}
		public BreakRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterBreakRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitBreakRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitBreakRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakRangeContext breakRange() throws RecognitionException {
		BreakRangeContext _localctx = new BreakRangeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_breakRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			match(DATE);
			setState(41);
			match(T__3);
			setState(42);
			match(DATE);
			setState(43);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SemesterDatesContext extends ParserRuleContext {
		public List<TerminalNode> DATE() { return getTokens(SyllabusDSLParser.DATE); }
		public TerminalNode DATE(int i) {
			return getToken(SyllabusDSLParser.DATE, i);
		}
		public SemesterDatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semesterDates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterSemesterDates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitSemesterDates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitSemesterDates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemesterDatesContext semesterDates() throws RecognitionException {
		SemesterDatesContext _localctx = new SemesterDatesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_semesterDates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__5);
			setState(46);
			match(T__1);
			setState(47);
			match(T__2);
			setState(48);
			match(DATE);
			setState(49);
			match(T__6);
			setState(50);
			match(DATE);
			setState(51);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DifficultyLevelsContext extends ParserRuleContext {
		public List<DifficultyEntryContext> difficultyEntry() {
			return getRuleContexts(DifficultyEntryContext.class);
		}
		public DifficultyEntryContext difficultyEntry(int i) {
			return getRuleContext(DifficultyEntryContext.class,i);
		}
		public DifficultyLevelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difficultyLevels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterDifficultyLevels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitDifficultyLevels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitDifficultyLevels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifficultyLevelsContext difficultyLevels() throws RecognitionException {
		DifficultyLevelsContext _localctx = new DifficultyLevelsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_difficultyLevels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__7);
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				difficultyEntry();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class DifficultyEntryContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(SyllabusDSLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SyllabusDSLParser.INT, i);
		}
		public DifficultyEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difficultyEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterDifficultyEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitDifficultyEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitDifficultyEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifficultyEntryContext difficultyEntry() throws RecognitionException {
		DifficultyEntryContext _localctx = new DifficultyEntryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_difficultyEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(INT);
			setState(60);
			match(T__1);
			setState(61);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CourseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SyllabusDSLParser.ID, 0); }
		public TerminalNode WS() { return getToken(SyllabusDSLParser.WS, 0); }
		public List<CategoryContext> category() {
			return getRuleContexts(CategoryContext.class);
		}
		public CategoryContext category(int i) {
			return getRuleContext(CategoryContext.class,i);
		}
		public CourseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_course; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterCourse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitCourse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitCourse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CourseContext course() throws RecognitionException {
		CourseContext _localctx = new CourseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_course);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__8);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(64);
				match(WS);
				}
			}

			setState(67);
			match(ID);
			setState(68);
			match(T__1);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				category();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class CategoryContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public CategoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_category; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterCategory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitCategory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitCategory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CategoryContext category() throws RecognitionException {
		CategoryContext _localctx = new CategoryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_category);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(T__1);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				assignment();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SyllabusDSLParser.STRING, 0); }
		public TerminalNode DATE() { return getToken(SyllabusDSLParser.DATE, 0); }
		public TerminalNode INT() { return getToken(SyllabusDSLParser.INT, 0); }
		public TerminalNode COLOR() { return getToken(SyllabusDSLParser.COLOR, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyllabusDSLListener ) ((SyllabusDSLListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyllabusDSLVisitor ) return ((SyllabusDSLVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__2);
			setState(82);
			match(STRING);
			setState(83);
			match(T__6);
			setState(84);
			match(DATE);
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(85);
				match(T__6);
				setState(86);
				match(INT);
				}
				break;
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(89);
				match(T__6);
				setState(90);
				match(COLOR);
				}
			}

			setState(93);
			match(T__4);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0013`\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0003\u0000\u0015\b\u0000\u0001\u0000"+
		"\u0003\u0000\u0018\b\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b"+
		"\u0000\f\u0000\u001c\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001$\b\u0001\u000b\u0001\f\u0001%\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0004\u00048\b\u0004\u000b\u0004\f\u00049\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003"+
		"\u0006B\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006G\b\u0006"+
		"\u000b\u0006\f\u0006H\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"N\b\u0007\u000b\u0007\f\u0007O\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\bX\b\b\u0001\b\u0001\b\u0003\b\\\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0001"+
		"\u0001\u0000\n\f`\u0000\u0012\u0001\u0000\u0000\u0000\u0002 \u0001\u0000"+
		"\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000"+
		"\u0000\b5\u0001\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000\f?\u0001"+
		"\u0000\u0000\u0000\u000eJ\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000\u0000"+
		"\u0000\u0012\u0014\u0003\b\u0004\u0000\u0013\u0015\u0003\u0002\u0001\u0000"+
		"\u0014\u0013\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000"+
		"\u0015\u0017\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0006\u0003\u0000"+
		"\u0017\u0016\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000"+
		"\u0018\u001a\u0001\u0000\u0000\u0000\u0019\u001b\u0003\f\u0006\u0000\u001a"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0000\u0000\u0001\u001f"+
		"\u0001\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000\u0000!#\u0005\u0002"+
		"\u0000\u0000\"$\u0003\u0004\u0002\u0000#\"\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&\u0003\u0001\u0000\u0000\u0000\'(\u0005\u0003\u0000\u0000()\u0005\r\u0000"+
		"\u0000)*\u0005\u0004\u0000\u0000*+\u0005\r\u0000\u0000+,\u0005\u0005\u0000"+
		"\u0000,\u0005\u0001\u0000\u0000\u0000-.\u0005\u0006\u0000\u0000./\u0005"+
		"\u0002\u0000\u0000/0\u0005\u0003\u0000\u000001\u0005\r\u0000\u000012\u0005"+
		"\u0007\u0000\u000023\u0005\r\u0000\u000034\u0005\u0005\u0000\u00004\u0007"+
		"\u0001\u0000\u0000\u000057\u0005\b\u0000\u000068\u0003\n\u0005\u00007"+
		"6\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:\t\u0001\u0000\u0000\u0000;<\u0005\u0011"+
		"\u0000\u0000<=\u0005\u0002\u0000\u0000=>\u0005\u0011\u0000\u0000>\u000b"+
		"\u0001\u0000\u0000\u0000?A\u0005\t\u0000\u0000@B\u0005\u0012\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CD\u0005\u000f\u0000\u0000DF\u0005\u0002\u0000\u0000EG\u0003\u000e"+
		"\u0007\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\r\u0001\u0000\u0000\u0000"+
		"JK\u0007\u0000\u0000\u0000KM\u0005\u0002\u0000\u0000LN\u0003\u0010\b\u0000"+
		"ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000P\u000f\u0001\u0000\u0000\u0000QR\u0005"+
		"\u0003\u0000\u0000RS\u0005\u0010\u0000\u0000ST\u0005\u0007\u0000\u0000"+
		"TW\u0005\r\u0000\u0000UV\u0005\u0007\u0000\u0000VX\u0005\u0011\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0007\u0000\u0000Z\\\u0005\u000e\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005"+
		"\u0005\u0000\u0000^\u0011\u0001\u0000\u0000\u0000\n\u0014\u0017\u001c"+
		"%9AHOW[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}