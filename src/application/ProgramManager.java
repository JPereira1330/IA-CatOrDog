package application;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.control.ListView;

public class ProgramManager {

	public static boolean addNewMusic(ListView<AudioClass> lvMusicas) {

		File musica;
		AudioClass metaDataMusica;

		musica = Ferramentas.selecionarArquivo(0);
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

	public static String selectArff() {

		File arff;

		arff = Ferramentas.selecionarArquivo(1);
		if (arff == null) {
			return null;
		}

		return arff.getAbsolutePath();
	}

	public static boolean removeMusic(ListView<AudioClass> lvMusicas) {
		int index = lvMusicas.getSelectionModel().getSelectedIndex();
		lvMusicas.getItems().remove(index);
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

	public static double[] analyseArff(String pathDatabaseArff, String pathDatabaseTeste, double tempoAprender, int quantiaQueAprender) {

		if (pathDatabaseArff.isEmpty() || pathDatabaseTeste.isEmpty())
			return null;

		WekaManager wekaArff = new WekaManager();

		wekaArff.setPathDatabase(pathDatabaseArff);
		wekaArff.setPathTestArff(pathDatabaseTeste);
		wekaArff.loadArffDatabases();
		
		return wekaArff.multilayerPerceptron("a", 0.2, tempoAprender, quantiaQueAprender);
	}

}
