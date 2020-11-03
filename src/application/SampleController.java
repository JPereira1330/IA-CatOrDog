package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController {

	String pathDatabaseArff;
	String pathDatabaseTeste;
	@FXML TextField porcentagemARFFDog;
	@FXML TextField porcentagemARFFCat;
	@FXML TextField porcentagemLerningRate;
	@FXML TextField porcentagemTrainngTime;
	@FXML ListView<AudioClass> lvMusicas;

	@FXML
	public void btnAddNewMusic() {
		ProgramManager.addNewMusic(lvMusicas);
	}

	@FXML
	public void btnSelectArffDatabase() {
		pathDatabaseArff = ProgramManager.selectArff();
	}
	
	@FXML
	public void btnSelectArffTeste() {
		pathDatabaseTeste = ProgramManager.selectArff();
	}
	
	@FXML
	public void btnAddNewFolder() {
		ProgramManager.addNewFolder(lvMusicas);
	}
	
	@FXML
	public void btnRemoveMusic() {
		ProgramManager.removeMusic(lvMusicas);
	}
	
	@FXML
	public void btnAnalyseArrf() {
		
		double tempoAprender;
		int quantiaQueAprender;
		double[] porcentagem = {0,0};
		
		if(porcentagemLerningRate.getText().isEmpty() || porcentagemTrainngTime.getText().isEmpty()) {
			return;
		}
		
		tempoAprender = Double.parseDouble(porcentagemLerningRate.getText());
		quantiaQueAprender = Integer.parseInt(porcentagemTrainngTime.getText());
		
		porcentagem = ProgramManager.analyseArff(pathDatabaseArff, pathDatabaseTeste, tempoAprender, quantiaQueAprender);
		if(porcentagem == null)
			return;

		porcentagemARFFDog.setText( String.format("%.2f", (porcentagem[0]*100)) +"%");
		porcentagemARFFCat.setText( String.format("%.2f", (porcentagem[1]*100)) +"%");
	}

}
