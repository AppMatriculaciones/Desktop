package models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class RequirementsProfile {

	@JsonProperty(access = Access.WRITE_ONLY)
	private String _id;
	private String type;
	private ArrayList<String> requirements = new ArrayList<String>();
	
	public RequirementsProfile() {
		super();
	}

	public RequirementsProfile(String type, ArrayList<String> requirements) {
		super();
		this.type = type;
		this.requirements = requirements;
	}
	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<String> requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return type;
	}
}
