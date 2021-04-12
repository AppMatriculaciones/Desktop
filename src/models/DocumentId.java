package models;

public class DocumentId {
	
	private String type;
	private String id;
	
	public DocumentId(String type, String id) {
		super();
		this.type = type;
		this.id = id;
	}

	public DocumentId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DocumentId [type=" + type + ", id=" + id + "]";
	}
	
	
}
