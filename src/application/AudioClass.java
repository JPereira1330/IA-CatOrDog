package application;

public class AudioClass {

	private String name;
	private int duration;
	private String filePath;
	private long spaceUsable;
	private String resultado;
	
	public AudioClass() {
		this.resultado = "";
	}
	
	public AudioClass(String name, int duration, String filePath, long spaceUsable) {
		super();
		this.name = name;
		this.duration = duration;
		this.filePath = filePath;
		this.spaceUsable = spaceUsable;
	}

	public AudioClass(String name, int duration, String filePath, long spaceUsable, String resultado) {
		super();
		this.name = name;
		this.duration = duration;
		this.filePath = filePath;
		this.spaceUsable = spaceUsable;
		this.resultado = resultado;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public long getSpaceUsable() {
		return spaceUsable;
	}
	
	public void setSpaceUsable(long spaceUsable) {
		this.spaceUsable = spaceUsable;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		if(getResultado() != "")
			return "Resultado: "+getResultado()+" \t Arquivo:"+getName();
		return getName();
	}
	
}
