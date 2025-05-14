// Generated from T:/Documents/DSL/src/SyllabusDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SyllabusDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SyllabusDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#syllabus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyllabus(SyllabusDSLParser.SyllabusContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#breaks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreaks(SyllabusDSLParser.BreaksContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#breakRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakRange(SyllabusDSLParser.BreakRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#semesterDates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemesterDates(SyllabusDSLParser.SemesterDatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#difficultyLevels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifficultyLevels(SyllabusDSLParser.DifficultyLevelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#difficultyEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifficultyEntry(SyllabusDSLParser.DifficultyEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#course}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCourse(SyllabusDSLParser.CourseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#category}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCategory(SyllabusDSLParser.CategoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyllabusDSLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SyllabusDSLParser.AssignmentContext ctx);
}