import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.*;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class SyllabusToHTML implements SyllabusDSLVisitor {

    public void exportToJSON(String filename){
        JSONObject outputJson = new JSONObject();

        // handle the courses
        JSONArray courseArray = new JSONArray();

        for(Course course : allCourses){
            JSONObject courseObj = new JSONObject();
            courseObj.put("courseName", course.name);

            JSONArray homeworkArray = new JSONArray();
            for(Assignments hw : course.homeworks){
                JSONObject hwObj = new JSONObject();
                hwObj.put("title", hw.name);
                hwObj.put("date", hw.date);
                hwObj.put("difficulty", hw.df);
                hwObj.put("color", hw.color);
                homeworkArray.put(hwObj);
            }

            JSONArray projectArray = new JSONArray();
            for (Assignments prj : course.projects) {
                JSONObject prjObj = new JSONObject();
                prjObj.put("title", prj.name);
                prjObj.put("date", prj.date);
                prjObj.put("difficulty", prj.df);
                prjObj.put("color", prj.color);
                projectArray.put(prjObj);
            }

            JSONArray testArray = new JSONArray();
            for (Assignments test : course.tests) {
                JSONObject testObj = new JSONObject();
                testObj.put("title", test.name);
                testObj.put("date", test.date);
                testObj.put("difficulty", test.df);
                testObj.put("color", test.color);
                testArray.put(testObj);
            }

            courseObj.put("homeworks", homeworkArray);
            courseObj.put("projects", projectArray);
            courseObj.put("tests", testArray);

            courseArray.put(courseObj);
        }
        outputJson.put("courseInfo", courseArray);

        //handle the semester dates
        JSONArray semesterArray = new JSONArray();
        for(BreakRange date : semesterDates.dates){
            JSONObject semesterJson = new JSONObject();
            semesterJson.put("start", date.startDate);
            semesterJson.put("end", date.endDate);
            semesterArray.put(semesterJson);
        }
        outputJson.put("semesterDates", semesterArray);

        JSONArray breaksArray = new JSONArray();
        for(BreakRange breaks : allBreaks){
            JSONObject breakJson = new JSONObject();
            breakJson.put("start", breaks.startDate);
            breakJson.put("end", breaks.endDate);
            breaksArray.put(breakJson);
        }
        outputJson.put("breakDates", breaksArray);

        JSONArray dfArray = new JSONArray();
        for(DifficultyLevel df : difficultyRating){
            JSONObject dfJson = new JSONObject();
            dfJson.put("level", df.df);
            dfJson.put("days", df.days);
            dfArray.put(dfJson);
        }
        outputJson.put("difficultyLevels", dfArray);

        try(FileWriter file = new FileWriter(filename)){
            file.write(outputJson.toString(4));
            System.out.println("JSON Exported to " + filename);
        } catch(IOException e){
            System.err.println("Error writing JSON: " + e.getMessage());
        }
    }

    private List<String> getParts(BreakRange dates){
        List<String> parts = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+").matcher(dates.startDate);

        while (matcher.find()) {
            parts.add(matcher.group());
        }
        Matcher matcher1 = Pattern.compile("\\d+").matcher(dates.endDate);
        while(matcher1.find()){
            parts.add(matcher1.group());
        }
        return parts;
    }

    public boolean isDateWithinRange(List<String> assignmentDate, List<String> semesterDate){
        //breaks values
        int startDay = Integer.parseInt(semesterDate.get(1));
        int startMonth = Integer.parseInt(semesterDate.get(0));
        int startYear = Integer.parseInt(semesterDate.get(2));
        int endDay = Integer.parseInt(semesterDate.get(4));
        int endMonth = Integer.parseInt(semesterDate.get(3));
        int endYear = Integer.parseInt(semesterDate.get(5));

        //assignment values
        int assignmentDay =  Integer.parseInt(assignmentDate.get(1));
        int assignmentMonth = Integer.parseInt(assignmentDate.get(0));
        int assignmentYear = Integer.parseInt(assignmentDate.get(2));

        if(assignmentYear > endYear || assignmentYear < startYear){
            return false;
        }

        if (assignmentYear == startYear) {
            if (assignmentMonth < startMonth) return false;
            if (assignmentMonth == startMonth && assignmentDay < startDay) return false;
        }

        if (assignmentYear == endYear) {
            if (assignmentMonth > endMonth) return false;
            if (assignmentMonth == endMonth && assignmentDay > endDay) return false;
        }

        return true;
    }

    static class Assignments{
        String name;
        String date;
        int df; // difficultly level
        String color; // optional

        public Assignments(String title, String givenDate, int weight, String givenColor) {
            name = title;
            date = givenDate;
            df = weight;
            color = givenColor;
        }
    }

    static class Course{
        String name;
        List<Assignments> homeworks = new ArrayList<>();
        List<Assignments> projects = new ArrayList<>();
        List<Assignments> tests = new ArrayList<>();

        public Course(String courseName) {
            name = courseName;
        }
    }

    static class BreakRange{
        String startDate;
        String endDate;

        public BreakRange(String start, String end){
            startDate = start;
            endDate = end;
        }
    }

    static class DifficultyLevel{
        // based on the difficulty we will study for this many days
        int df;
        int days;

        public DifficultyLevel(int difficulty, int time){
            df = difficulty;
            days = time;
        }
    }

    static class SemesterDates {
        List<BreakRange> dates = new ArrayList<>();

        public void addDate(String start, String end){
            dates.add(new BreakRange(start, end));
        }

        public void printDates(){
            for(BreakRange  date : dates){
                System.out.println("Semester Dates: ");
                System.out.println("Start: " + date.startDate + ", End: " + date.endDate);
            }
        }
    }

    List<Course> allCourses = new ArrayList<>();
    List<BreakRange> allBreaks = new ArrayList<>();
    List<DifficultyLevel> difficultyRating = new ArrayList<>();
    SemesterDates semesterDates = new SemesterDates();
    private Course currentCourse = null;
    private String currentCategory = null;


    @Override
    public Object visitSyllabus(SyllabusDSLParser.SyllabusContext ctx) {
        // Visit semester dates, breaks, difficulty levels, courses
        if (ctx.breaks() != null) {
            for (ParseTree child : ctx.breaks().children) {
                visit(child);
            }
        }

        if(ctx.semesterDates() != null){
            visit(ctx.semesterDates());
        }

        if (ctx.difficultyLevels() != null) {
            for (ParseTree child : ctx.difficultyLevels().children) {
                visit(child);
            }
        }

        for (SyllabusDSLParser.CourseContext courseCtx : ctx.course()) {
            visitCourse(courseCtx);
        }
        return null;
    }

    @Override
    public Object visitBreaks(SyllabusDSLParser.BreaksContext ctx) {

        return null;
    }

    @Override
    public Object visitBreakRange(SyllabusDSLParser.BreakRangeContext ctx) {
        String start = ctx.DATE(0).getText();
        String end = ctx.DATE(1).getText();
        BreakRange breaks = new BreakRange(start, end);

        //check for semantic meaning
        List<String> parts = getParts(breaks);

        // Extract date components: year, month, and day
        int startYear = Integer.parseInt(parts.get(2));
        int endYear = Integer.parseInt(parts.get(5));
        int startMonth = Integer.parseInt(parts.get(0));
        int endMonth = Integer.parseInt(parts.get(3));
        int startDay = Integer.parseInt(parts.get(1));
        int endDay = Integer.parseInt(parts.get(4));

        // Year check
        if (startYear > endYear) {
            throw new RuntimeException("Invalid break date: end date year must be after start date.");
        } else if (startYear == endYear) {
            // Month check if the years are the same
            if (startMonth > endMonth) {
                throw new RuntimeException("Invalid break date: end date month must be after start date month.");
            } else if (startMonth == endMonth) {
                // Day check if the months are the same
                if (startDay > endDay) {
                    throw new RuntimeException("Invalid break date: end date day must be after start date day.");
                }
            }
        }


        allBreaks.add(breaks);
        return null;
    }

    @Override
    public Object visitSemesterDates(SyllabusDSLParser.SemesterDatesContext ctx) {
        String start = ctx.DATE(0).getText();
        String end = ctx.DATE(1).getText();
        BreakRange semester = new BreakRange(start, end);
        semesterDates.addDate(start, end);

        List<String> parts = getParts(semester);

        int startDay = Integer.parseInt(parts.get(1));
        int startMonth = Integer.parseInt(parts.get(0));
        int startYear = Integer.parseInt(parts.get(2));
        int endDay = Integer.parseInt(parts.get(4));
        int endMonth = Integer.parseInt(parts.get(3));
        int endYear = Integer.parseInt(parts.get(5));

        for(BreakRange breaks : allBreaks){
            List<String> breakParts = getParts(breaks);

            int breakStartDay = Integer.parseInt(breakParts.get(1));
            int breakStartMonth = Integer.parseInt(breakParts.get(0));
            int breakStartYear = Integer.parseInt(breakParts.get(2));
            int breakEndDay = Integer.parseInt(breakParts.get(4));
            int breakEndMonth = Integer.parseInt(breakParts.get(3));
            int breakEndYear = Integer.parseInt(breakParts.get(5));

            // Check if the break date falls within the semester date range
            if (breakStartYear < startYear || (breakStartYear == startYear && breakStartMonth < startMonth) ||
                    (breakStartYear == startYear && breakStartMonth == startMonth && breakStartDay < startDay)) {
                throw new RuntimeException("Break date starts before semester begins.");
            }

            if (breakEndYear > endYear || (breakEndYear == endYear && breakEndMonth > endMonth) ||
                    (breakEndYear == endYear && breakEndMonth == endMonth && breakEndDay > endDay)) {
                throw new RuntimeException("Break date ends after semester ends.");
            }
        }
        return null;
    }

    @Override
    public Object visitDifficultyLevels(SyllabusDSLParser.DifficultyLevelsContext ctx) {
        return null;
    }

    @Override
    public Object visitDifficultyEntry(SyllabusDSLParser.DifficultyEntryContext ctx) {
        int df = Integer.parseInt(ctx.INT(0).getText());
        int days = Integer.parseInt(ctx.INT(1).getText());
        //check for semantic meaning
        if(df < 1 || df > 5){
            throw new RuntimeException("Invalid difficulty level: must be between 1 and 5.");
        }
        if(days < 0){
            throw new RuntimeException("Invalid difficulty level day: must be greater than 0");
        }

        DifficultyLevel rating = new DifficultyLevel(df, days);
        difficultyRating.add(rating);
        return null;
    }

    @Override
    public Object visitCourse(SyllabusDSLParser.CourseContext ctx) {
        String courseName = ctx.ID().getText();

        currentCourse = new Course(courseName);
        allCourses.add(currentCourse);

        for (SyllabusDSLParser.CategoryContext catCtx : ctx.category()) {
            visit(catCtx); // visit each category, will set currentCategory
        }

        currentCourse = null;
        return null;
    }

    @Override
    public Object visitCategory(SyllabusDSLParser.CategoryContext ctx) {
        currentCategory = ctx.getChild(0).getText();

        for (SyllabusDSLParser.AssignmentContext aCtx : ctx.assignment()) {
            visit(aCtx);
        }

        currentCategory = null;
        return null;
    }

    @Override
    public Object visitAssignment(SyllabusDSLParser.AssignmentContext ctx) {
        String title = ctx.STRING().getText().replace("\"", "");
        String date = ctx.DATE().getText();
        // get weight if there is one, otherwise get 1 as default
        int weight = ctx.INT() != null ? Integer.parseInt(ctx.INT().getText()) : 1;
        String color = ctx.COLOR() != null ? ctx.COLOR().getText() : "red"; //red as default

        Assignments a = new Assignments(title, date, weight, color);

        //check for semantic meaning
        List<String> assignmentParts = getParts(new BreakRange(date, date));
        List<String> semester = getParts(semesterDates.dates.get(0));
        if (!isDateWithinRange(assignmentParts, semester)) {
            throw new RuntimeException("Assignment \"" + title + "\" has an invalid date: " + date + " is outside the semester range.");
        }

        //add to proper array and set color based on category
        if (currentCourse != null && currentCategory != null) {
            switch (currentCategory) {
                case "HOMEWORK":
                    currentCourse.homeworks.add(a);
                    a.color = "red";
                    break;
                case "PROJECTS":
                    currentCourse.projects.add(a);
                    a.color = "blue";
                    break;
                case "TEST":
                    currentCourse.tests.add(a);
                    a.color = "green";
                    break;
            }
        }

        //check if due dates are during a break
        // already have assignmentParts
        for(BreakRange brDate : allBreaks){
            List<String> breaks = getParts(brDate);
            if(isDateWithinRange(assignmentParts, breaks)){
                a.color = "yellow";
                break;
            }
        }
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        //iterate over all the children
        for(int i =0; i < ruleNode.getChildCount(); i++){
            visit(ruleNode.getChild(i));
        }
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        //System.out.println("Terminal Node: " + terminalNode.getText());
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        System.out.println("Error Node: " + errorNode.getText());
        return null;
    }
}


