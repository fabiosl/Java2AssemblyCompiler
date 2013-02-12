

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import core.modeling.metamodel.Classe;
//import core.modeling.metamodel.Colecao;

public class Util {
	public static List<String> getFilesInOrder(String folder, String extension) {
		File f = new File(folder);
		if (!f.exists()){
			System.err.println("Couldn't open the file/directory!");
			System.exit(1);
		}
		
		List<String> fileNames = new ArrayList<String>();

		File testsDir = new File(folder);

		File[] files = testsDir.listFiles();
		for (File file : files) {
			
			String fileName = file.getName();
			if (fileName.endsWith(extension)) {
				fileNames.add(fileName);
			}
		}

		Collections.sort(fileNames);
		return fileNames;
	}
}
