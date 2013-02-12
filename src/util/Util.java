package util;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
	public static List<String> getFiles(String folder, String extension) {
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
