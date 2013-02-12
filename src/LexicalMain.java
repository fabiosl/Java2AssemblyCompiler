import java.io.FileReader;
import java.io.IOException;

public class LexicalMain {
	public static void executeLexicalAnalyzer(String fileName) throws IOException {
		System.out.println("Running lexical analysis for " + fileName);

		LexicalAnalyzer scanner = new LexicalAnalyzer(new FileReader(fileName));
		while (scanner.hasNext()) {
			scanner.next_token();
		}
		System.out.println("Lexical Analysis finished successfully! \n");
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("\tPlease inform the file");
			System.exit(1);
		}
		try {
			executeLexicalAnalyzer(args[0]);
		} catch (Exception e) {
			System.out.println("Error on lexical Analysis:");
			System.out.println(e.getMessage());
		}
	}
}
