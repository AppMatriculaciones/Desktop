package models;

public class Requirement {
	
	private String path;
	private int status;
	
	public Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Requirement(String path, int status) {
		super();
		this.path = path;
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
