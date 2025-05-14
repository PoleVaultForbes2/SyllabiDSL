import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class Test {

    public static void main(String[] args) throws Exception {
        // get input from test file
        CharStream input = CharStreams.fromFileName("input/input2.txt");

        // create lexer and the token stream that will be fed to the parser
        SyllabusDSLLexer lexer = new SyllabusDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SyllabusDSLParser parser = new SyllabusDSLParser(tokens);

        ParseTree tree = parser.syllabus();

        //print the tree
        System.out.println(tree.toStringTree(parser));
        System.out.println("END OF PARSING! NOW FOR VISITOR! \n");

        SyllabusToHTML visitor = new SyllabusToHTML();
        visitor.visit(tree);
        visitor.exportToJSON("input/info.json");
        

        String intellijServerUrl = "http://localhost:63342/DSL/input/calendar.html?_ijt=bfbvturerl0cduoujmhvmf130v&_ij_reload=RELOAD_ON_SAVE";

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(intellijServerUrl));
            } else {
                System.out.println("Desktop not supported. Please open the following URL in your browser: " + intellijServerUrl);
            }
        } catch (Exception e) {
            System.err.println("Error opening browser: " + e.getMessage());
            System.out.println("Please open the following URL in your browser: " + intellijServerUrl);
        }
    }
}