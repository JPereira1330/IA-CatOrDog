package application;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.scene.control.ListView;

public class ProgramManager {

	public static boolean addNewMusic(ListView<AudioClass> lvMusicas) {

		File musica;
		AudioClass metaDataMusica;

		musica = Ferramentas.selecionarArquivo();
		if (musica == null) {
			return false;
		}

		metaDataMusica = new AudioClass();
		metaDataMusica.setName(musica.getName());
		metaDataMusica.setSpaceUsable(musica.getUsableSpace());
		metaDataMusica.setFilePath(musica.getAbsolutePath());

		lvMusicas.getItems().add(metaDataMusica);

		return true;
	}

	public static boolean addNewFolder(ListView<AudioClass> lvMusicas) {

		ArrayList<File> musicas;
		AudioClass metaDataMusica;

		musicas = Ferramentas.selecionarPasta();
		if (musicas == null) {
			return false;
		}

		for (int i = 0; musicas.size() > i; i++) {
			metaDataMusica = new AudioClass();
			metaDataMusica.setName(musicas.get(i).getName());
			metaDataMusica.setSpaceUsable(musicas.get(i).getUsableSpace());
			metaDataMusica.setFilePath(musicas.get(i).getAbsolutePath());

			lvMusicas.getItems().add(metaDataMusica);
		}

		return true;
	}

	public static boolean playMusic(ListView<AudioClass> lvMusicas) {

		int indice = lvMusicas.getSelectionModel().getSelectedIndex();

		AudioManager am = new AudioManager(lvMusicas.getItems().get(indice).getFilePath());
		InputStream stream = new ByteArrayInputStream(am.getSamples());
		
		am.playMusic(stream);
		
		return false;
	}
}
