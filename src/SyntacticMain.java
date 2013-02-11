import java.io.FileReader;
import java.io.IOException;

public class SyntacticMain {
	public static void executeSyntacticAnalyzer(String fileName)
			throws Exception {
		System.out.println("Running Lexical and Syntactical analysis for:  " + fileName);
		
		SyntacticAnalyzer parser = new SyntacticAnalyzer(new LexicalAnalyzer(new FileReader(fileName)));
		parser.parse();
		
		System.out.println("Lexical and Syntactical completed successfully for: " + fileName);
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Forma de uso incorreta! Veja abaixo a formas correta para executar!\n");
			System.err.println("\tjava -jar AnalisadorSintaticoOclJml.jar <endereco_do_arquivo>");
			System.exit(1);
		}

		try {
			executeSyntacticAnalyzer(args[0]);
		} catch (Exception e) {
			System.out.println(">>> Ocorreu um erro durante a analise, impossivel continuar, veja os logs abaixo:");
			System.out.println(e.getMessage());
		}

		System.out.println("=======================================");
	}
}
