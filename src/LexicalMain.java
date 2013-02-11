import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LexicalMain {
	public static void executeLexicalAnalyzer(String fileName) throws IOException {
		System.out.println("***************************************");
		System.out.println("Running lexical analysis for " + fileName);
		System.out.println("***************************************");

		LexicalAnalyzer scanner = new LexicalAnalyzer(new FileReader(fileName));
		while (scanner.hasNext()) {
			scanner.next_token();
		}
		System.out.println("Lexical Analysis finished successfully!");
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Forma de uso incorreta! Veja abaixo a formas correta para executar!\n");
			System.err.println("\tjava -jar AnalisadorLexicoOclJml.jar <endereco_do_arquivo>");
			System.exit(1);
		}

		try {
			executeLexicalAnalyzer(args[0]);
		} catch (Exception e) {
			System.out.println(">>> Ocorreu um erro durante a analise, impossivel continuar, veja os logs abaixo:");
			System.out.println(e.getMessage());
		}

		System.out.println("=======================================");
	}
}
