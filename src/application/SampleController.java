package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SampleController{

	@FXML ListView<AudioClass> lvMusicas;
	
	@FXML
	public void btnAddNewMusic() {
		ProgramManager.addNewMusic(lvMusicas);
	}
	
	@FXML
	public void btnRemoveMusic() {}
	
	@FXML
	public void btnAnalyseMusic() {
		AudioManager.playMusic(lvMusicas.getItems().get(0).getFilePath());
	}
	
	@FXML
	public void btnSaveARRF() {}
	
}
