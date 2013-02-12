import java.io.FileReader;

import junit.framework.TestCase;

public class SyntacticAnalyzerTest extends TestCase {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final String TESTS_DIR = System.getProperty("user.dir") + FILE_SEPARATOR + "input" + FILE_SEPARATOR + "files" + FILE_SEPARATOR + "examples";
	private static final String TESTS_ERRORS_DIR = TESTS_DIR + FILE_SEPARATOR + "errors";

	private void executeSyntacticAnalyzer(String fileName) throws Exception{
		Thread.sleep(50);
		System.out.println("\nRunning Lexical and Syntactical analysis for:  " + fileName);
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(new FileReader(fileName));
		SyntacticAnalyzer parser = new SyntacticAnalyzer(lexicalAnalyzer); // The Syntactic analyzer receives the Lexical Analyzer as an input
		parser.parse();
		System.out.println("Lexical and Syntactical completed successfully for: " + fileName+ "\n");
	}
	
	public void testAll() throws Exception {
		System.out.println("Running Syntactic Analyzer expecting well formed files... ");
		
		int testCounter = 0;
		for (String fileName : Util.getFilesInOrder(TESTS_DIR,".java")) {
			try {
				executeSyntacticAnalyzer(TESTS_DIR + FILE_SEPARATOR + fileName);
			} catch (Exception e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
			testCounter++;
		}

		System.out.println("Number of Analysed files expecting success: " + testCounter);
	}

	public void testAllErrors() throws Exception {
		System.out.println("\n\nRunning Syntactic Analyzer expecting files with errors... ");
		
		int testCounter = 0;
		for (String fileName : Util.getFilesInOrder(TESTS_ERRORS_DIR,".java")) {
			try {
				executeSyntacticAnalyzer(TESTS_ERRORS_DIR + FILE_SEPARATOR + fileName);
				fail("An error was expected!");
			} catch (Exception e) {
				System.out.println("An error happened: " + e.getMessage() + "\n\n");
			}
			testCounter++;
		}
		System.out.println("Nummber of Analysed files expecting errors: " + testCounter);
	}
}
