package lexical_analyzer;
import junit.framework.TestCase;
import util.Util;

public class LexicalAnalyzerTest extends TestCase {
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");

	private static final String TESTS_DIR = System.getProperty("user.dir") + FILE_SEPARATOR + "input" + FILE_SEPARATOR + "files"+ FILE_SEPARATOR + "examples";

	public void testAll() throws Exception {
		System.out.println("===============================================");
		System.out.println("##           Running lexical tests           ##");

		int testCounter = 0;
		for (String fileName : Util.getFiles(TESTS_DIR, ".java")) {
			try {
				LexicalMain.executeLexicalAnalyzer(TESTS_DIR + FILE_SEPARATOR+ fileName);
			} catch (Exception e) {
				e.printStackTrace();
				fail(e.getMessage());
			}
			testCounter++;
		}

		System.out.println("===============================================");
		System.out.println("Number of analyzed Files:" + testCounter);
	}
}
