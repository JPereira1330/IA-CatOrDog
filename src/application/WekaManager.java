package application;

import java.io.File;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaManager {

	private String pathDatabase;
	private String pathTestArff;
	private Instances instanciasDB;
	private Instance instanciaTeste;
	
	public boolean loadArffDatabases() {
		
		try {
			
			// Database
			DataSource ds = new DataSource(pathDatabase);
			setInstanciasDB(ds.getDataSet());
			getInstanciasDB().setClassIndex(getInstanciasDB().numAttributes() - 1);

			// Database Teste
			ArffLoader al = new ArffLoader();
			al.setFile(new File(pathTestArff));
			setInstanciaTeste(al.getDataSet().get(0));
			getInstanciaTeste().setDataset(getInstanciasDB());
					
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}

		return true;
	}


	public double[] multilayerPerceptron(String hiddenLayers, double momentum, double learningRate, int trainningTime) {
		
		double[] retorno = {0,0};
		MultilayerPerceptron mlp = new MultilayerPerceptron();

		mlp.setHiddenLayers(hiddenLayers);
		mlp.setMomentum(momentum);
		mlp.setLearningRate(learningRate);
		mlp.setTrainingTime(trainningTime);
		
		try {
			mlp.buildClassifier(getInstanciasDB());
			retorno = mlp.distributionForInstance(getInstanciaTeste());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}
	
	public Instances getInstanciasDB() {
		return instanciasDB;
	}

	public void setInstanciasDB(Instances instanciasDB) {
		this.instanciasDB = instanciasDB;
	}

	public Instance getInstanciaTeste() {
		return instanciaTeste;
	}

	public void setInstanciaTeste(Instance instanciaTeste) {
		this.instanciaTeste = instanciaTeste;
	}

	public String getPathDatabase() {
		return pathDatabase;
	}

	public void setPathDatabase(String pathDatabase) {
		this.pathDatabase = pathDatabase;
	}

	public String getPathTestArff() {
		return pathTestArff;
	}

	public void setPathTestArff(String pathTestArff) {
		this.pathTestArff = pathTestArff;
	}
	
}
