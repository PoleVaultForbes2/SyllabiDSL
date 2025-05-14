// Generated from T:/Documents/DSL/src/SyllabusDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SyllabusDSLParser}.
 */
public interface SyllabusDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#syllabus}.
	 * @param ctx the parse tree
	 */
	void enterSyllabus(SyllabusDSLParser.SyllabusContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#syllabus}.
	 * @param ctx the parse tree
	 */
	void exitSyllabus(SyllabusDSLParser.SyllabusContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#breaks}.
	 * @param ctx the parse tree
	 */
	void enterBreaks(SyllabusDSLParser.BreaksContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#breaks}.
	 * @param ctx the parse tree
	 */
	void exitBreaks(SyllabusDSLParser.BreaksContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#breakRange}.
	 * @param ctx the parse tree
	 */
	void enterBreakRange(SyllabusDSLParser.BreakRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#breakRange}.
	 * @param ctx the parse tree
	 */
	void exitBreakRange(SyllabusDSLParser.BreakRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#semesterDates}.
	 * @param ctx the parse tree
	 */
	void enterSemesterDates(SyllabusDSLParser.SemesterDatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#semesterDates}.
	 * @param ctx the parse tree
	 */
	void exitSemesterDates(SyllabusDSLParser.SemesterDatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#difficultyLevels}.
	 * @param ctx the parse tree
	 */
	void enterDifficultyLevels(SyllabusDSLParser.DifficultyLevelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#difficultyLevels}.
	 * @param ctx the parse tree
	 */
	void exitDifficultyLevels(SyllabusDSLParser.DifficultyLevelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#difficultyEntry}.
	 * @param ctx the parse tree
	 */
	void enterDifficultyEntry(SyllabusDSLParser.DifficultyEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#difficultyEntry}.
	 * @param ctx the parse tree
	 */
	void exitDifficultyEntry(SyllabusDSLParser.DifficultyEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#course}.
	 * @param ctx the parse tree
	 */
	void enterCourse(SyllabusDSLParser.CourseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#course}.
	 * @param ctx the parse tree
	 */
	void exitCourse(SyllabusDSLParser.CourseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#category}.
	 * @param ctx the parse tree
	 */
	void enterCategory(SyllabusDSLParser.CategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#category}.
	 * @param ctx the parse tree
	 */
	void exitCategory(SyllabusDSLParser.CategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyllabusDSLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SyllabusDSLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyllabusDSLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SyllabusDSLParser.AssignmentContext ctx);
}