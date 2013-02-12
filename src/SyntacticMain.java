import java.io.FileReader;

public class SyntacticMain {
	private final static String EXTENSION = ".java";
	
	public static void main(String[] args){
		String helpMessage = "Java2Assembly Compiler \n" +
				 "Lexical + Syntactical analyzer modules! \n" +
				 "You can analyze a whole directory (-d sourceDirectory) or a sigle file. (-f sourceFile.java).";
		if(args.length == 0){
			System.out.println(helpMessage);
			System.exit(1);
		}

		String firstArg = args[0];
		if (firstArg.equals("-d")) {
			analyzeDirectory(args);
		}
		else if(firstArg.equals("-f")) {
			analyzeFile(args);
		}
		else{
			System.out.println(helpMessage);
		}
	}
	
	private static void analyzeFile(String[] args) {
		if (args.length < 2){
			System.err.println("Please inform file.");
			System.exit(1);
		}
		String filePath = args[1];
		if (filePath.endsWith(".java")){
			executeSyntacticAnalyzer(filePath);
		}
		else{
			System.err.println("Not a java file. Please use a java file as a parameter.");
			System.exit(1);
		}
	}

	private static void analyzeDirectory(String[] args){
		if (args.length < 2){
			System.err.println("Please inform directory.");
			System.exit(1);
		}
		
		String location = addSlashIfNeeded(args[1]);
		int testCounter = 0;
		for (String fileName : Util.getFilesInOrder(location, EXTENSION)) {
			executeSyntacticAnalyzer(location + fileName);
			testCounter++;
		}
		System.out.println("\nNumber of Analysed files: " + testCounter);
		
	}

	private static String addSlashIfNeeded(String string){
		if (! string.endsWith("/")){
			string += "/";
		}
		return string;
	}
	
	public static void executeSyntacticAnalyzer(String fileName) {
		try{
			Thread.sleep(50);
			System.out.println("\nRunning Lexical and Syntactical analysis for:  " + fileName);
			LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(new FileReader(fileName));
			SyntacticAnalyzer parser = new SyntacticAnalyzer(lexicalAnalyzer); // The Syntactic analyzer receives the Lexical Analyzer as an input
			parser.parse();
			System.out.println("Lexical and Syntactical completed successfully for: " + fileName+ "\n");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
