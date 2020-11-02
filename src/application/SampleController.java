package application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SampleController {

	@FXML
	ListView<AudioClass> lvMusicas;

	@FXML
	public void btnAddNewMusic() {
		ProgramManager.addNewMusic(lvMusicas);
	}

	@FXML
	public void btnRemoveMusic() {
	}

	@FXML
	public void btnAnalyseMusic() {

	}

	@FXML
	public void btnPlayMusic() {
		int indice = 0; //lvMusicas.getSelectionModel().getSelectedIndex();
		AudioManager am = new AudioManager(lvMusicas.getItems().get(indice).getFilePath());
		InputStream stream = new ByteArrayInputStream(am.getSamples());
		am.playMusic(stream);
	}

	@FXML
	public void btnSaveARRF() {
	}

}
