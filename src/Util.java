

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import core.modeling.metamodel.Classe;
//import core.modeling.metamodel.Colecao;

public class Util {
	public static List<String> getFilesInOrder(String folder, String extension) {
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

//	public static Classe getClasseById(List<Classe> classes, String id) {
//		if (classes != null && !classes.isEmpty()) {
//			for (Classe classe : classes) {
//				if (classe.getId().toUpperCase().equals(id.toUpperCase())) {
//					return classe;
//				}
//			}
//		}
//		return null;
//	}
//
//	public static Classe getClasseByIdPadrao(List<Classe> classes, String nome) {
//		if (classes != null && !classes.isEmpty()) {
//			for (Classe classe : classes) {
//				if (classe.getId().equalsIgnoreCase(nome)) {
//					return classe;
//				}
//			}
//		}
//		return null;
//	}
//
//	public static Classe getClasseByName(List<Classe> classes, String nome) {
//		if (classes != null && !classes.isEmpty()) {
//			for (Classe classe : classes) {
//				if (classe.getNome().equalsIgnoreCase(nome)) {
//					return classe;
//				}
//			}
//		}
//		return null;
//	}
//
//	public static String getNomeAtributoPadraoUML(Classe classeDoAtributo) {
//		String nomeAtributo = classeDoAtributo.isColecao() ? ((Colecao) classeDoAtributo)
//				.getTipoObjetos().getNome() : classeDoAtributo.getNome();
//		String caracterInicial = nomeAtributo.substring(0, 1);
//		String retorno = nomeAtributo.replaceFirst(caracterInicial,
//				caracterInicial.toLowerCase());
//		return retorno;
//	}
}
