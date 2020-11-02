package application;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.stage.FileChooser;

public class Ferramentas {

	public static File selecionarArquivo() {

		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.WAV", "*.wav"));
		fileChooser.setInitialDirectory(new File("C:\\Users"));
		
		File imgSelec = fileChooser.showOpenDialog(null);
		if (imgSelec != null) {
			return imgSelec;
		}

		return null;
	}

	public static ArrayList<File> selecionarPasta() {

		int ret;
		File path;
		String arquivos[];
		JFileChooser fileChooser = new JFileChooser();
		ArrayList<File> arquivosList = new ArrayList<>();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		ret = fileChooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			return null;
		}
		
		path = fileChooser.getCurrentDirectory();
		if(path == null) {
			return null;
		}
		
		arquivos = path.list();
		
		for(int i = 0; i < arquivos.length; i++)
			if(arquivos[i].endsWith(".wav") || arquivos[i].endsWith(".WAV"))
				arquivosList.add(new File(arquivos[i]));
		
		return arquivosList;
	}

}