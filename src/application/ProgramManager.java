package application;

import java.io.File;

import javafx.scene.control.ListView;

public class ProgramManager {

	public static boolean addNewMusic( ListView<AudioClass> lvMusicas ) {
		
		File musica;
		AudioClass metaDataMusica;
		
		musica = Ferramentas.selecionarArquivo();
		if(musica == null) {
			return false;
		}
		
		metaDataMusica = new AudioClass();
		metaDataMusica.setName(musica.getName());
		metaDataMusica.setSpaceUsable(musica.getUsableSpace());
		metaDataMusica.setFilePath(musica.getAbsolutePath());
		
		lvMusicas.getItems().add(metaDataMusica);
		
		return true;
	}
	
}
