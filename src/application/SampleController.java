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
	public void btnAddNewFolder() {
		ProgramManager.addNewFolder(lvMusicas);
	}
	
	@FXML
	public void btnRemoveMusic() {
	}

	@FXML
	public void btnAnalyseMusic() {

	}

	@FXML
	public void btnPlayMusic() {
		ProgramManager.playMusic(lvMusicas);
	}

	@FXML
	public void btnSaveARRF() {
	}

}
