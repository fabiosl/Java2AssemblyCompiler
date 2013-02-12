import java.io.IOException;

import java_cup.internal_error;

public class AnalyzersGenerator {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator"); 
	private static final String OUTPUT_DIR = "outputSrc";
	private static final String FLEX_FILE_NAME = "files" + FILE_SEPARATOR + "java.flex";
	private static final String CUP_FILE_NAME = "files" + FILE_SEPARATOR + "java.cup";

	public static void generateLexicalAnalyzer() {
		System.out.println("Generating lexical analyzer (JFlex) ...");
		String[] args = { FLEX_FILE_NAME, "-d", OUTPUT_DIR };
		JFlex.Main.main(args);
		System.out.println("Lexical Analyzer generated Successfully! \n\n");
	}

	
	public static void generateSyntacticAnalyzer() throws internal_error, IOException, Exception {
		
		System.out.println("Generating Syntatic Analyzer (CUP) ...");
		String[] args =  new String[] { "-parser", "SyntacticAnalyzer", 
							  "-destdir", OUTPUT_DIR, 
							  "-interface", CUP_FILE_NAME };

		java_cup.Main.main(args); 
		Thread.sleep(1000); // CUP log comes assynchronously. 
		System.out.println("Syntactic Analyzer generated Successfully!");
	}

	public static void main(String[] args) throws internal_error, IOException, Exception {
		generateLexicalAnalyzer();
		System.out.println("#######################################################################################################################################################################################################################\n\n");
		generateSyntacticAnalyzer();
	}
}
