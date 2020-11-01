package application;

public class AudioClass {

	private String name;
	private int duration;
	private String filePath;
	private long spaceUsable;
	
	public AudioClass() {}
	
	public AudioClass(String name, int duration, String filePath, long spaceUsable) {
		super();
		this.name = name;
		this.duration = duration;
		this.filePath = filePath;
		this.spaceUsable = spaceUsable;
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

	@Override
	public String toString() {
		return getName();
	}
	
}
