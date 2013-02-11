import junit.framework.TestCase;

public class SyntacticAnalyzerTest extends TestCase {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");

	private static final String TESTS_DIR = System.getProperty("user.dir")
			+ FILE_SEPARATOR + "input" + FILE_SEPARATOR + "files" + FILE_SEPARATOR + "examples";

	private static final String TESTS_ERRORS_DIR = TESTS_DIR + FILE_SEPARATOR + "errors";

	public void testAll() throws Exception {
		System.out.println("Running Syntactic Analyzer expecting well formed files... ");
		
		int testCounter = 0;
		for (String fileName : Util.getFilesInOrder(TESTS_DIR,".java")) {
			try {
				SyntacticMain.executeSyntacticAnalyzer(TESTS_DIR + FILE_SEPARATOR + fileName);
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
				SyntacticMain.executeSyntacticAnalyzer(TESTS_ERRORS_DIR + FILE_SEPARATOR + fileName);
				fail("An error was expected!");
			} catch (Exception e) {
				System.out.println("An error happened: " + e.getMessage() + "!");
			}
			testCounter++;
		}

		System.out.println("Nummber of Analysed files expecting errors: " + testCounter);
	}
}
