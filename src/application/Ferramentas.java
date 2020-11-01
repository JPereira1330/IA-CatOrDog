package application;

import java.io.File;

import javafx.stage.FileChooser;

public class Ferramentas {

	public static File selecionarArquivo() {
		
		File arqSelected;
		FileChooser fileChooser;
		
		fileChooser = new FileChooser();
		
		arqSelected = fileChooser.showOpenDialog(null);
		if (arqSelected != null)
			return arqSelected;
		
		return null;
	}

}
