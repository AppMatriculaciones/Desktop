package models;

public class Tutor {

	private DocumentId document_id;
	private String name;
	private String first_surname;
	private String second_surname;
	
	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(DocumentId document_id, String name, String first_surname, String second_surname) {
		super();
		this.document_id = document_id;
		this.name = name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
	}
	
	public DocumentId getDocument_id() {
		return document_id;
	}

	public void setDocument_id(DocumentId document_id) {
		this.document_id = document_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_surname() {
		return first_surname;
	}

	public void setFirst_surname(String first_surname) {
		this.first_surname = first_surname;
	}

	public String getSecond_surname() {
		return second_surname;
	}

	public void setSecond_surname(String second_surname) {
		this.second_surname = second_surname;
	}

	@Override
	public String toString() {
		return document_id+" "+name+" "+first_surname+" "+second_surname;
	}
}
