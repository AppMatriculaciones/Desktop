package models;

import org.json.simple.JSONObject;

public class Uf {

	String _id;
	String code;
	String name;
	int duration;
	Boolean isProject;
	Boolean isSintesis;
	Boolean isFct;
	Boolean isLanguage;
	String mp_id;
	
	public Uf(String code, String name, int duration, Boolean isProject, Boolean isSintesis, Boolean isFct,
			Boolean isLanguage, String mp_id) {
		super();
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.isProject = isProject;
		this.isSintesis = isSintesis;
		this.isFct = isFct;
		this.isLanguage = isLanguage;
		this.mp_id = mp_id;
	}
	
	public Uf(JSONObject jsonUf) {
		super();
		this.code = (String) jsonUf.get("code");
		this.name = (String) jsonUf.get("name");
		this.duration = (int) jsonUf.get("duration");
		this.isProject = (Boolean) jsonUf.get("isProject");
		this.isSintesis = (Boolean) jsonUf.get("isSintesis");
		this.isFct = (Boolean) jsonUf.get("isFct");
		this.isLanguage = (Boolean) jsonUf.get("isLanguage");
		this.mp_id = (String) jsonUf.get("mp_id");
	}
	
	public Uf() {
		super();
	}

	public String get_id() {
		return _id;
	}

	
	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Boolean getIsProject() {
		return isProject;
	}

	public void setIsProject(Boolean isProject) {
		this.isProject = isProject;
	}

	public Boolean getIsSintesis() {
		return isSintesis;
	}

	public void setIsSintesis(Boolean isSintesis) {
		this.isSintesis = isSintesis;
	}

	public Boolean getIsFct() {
		return isFct;
	}

	public void setIsFct(Boolean isFct) {
		this.isFct = isFct;
	}

	public Boolean getIsLanguage() {
		return isLanguage;
	}

	public void setIsLanguage(Boolean isLanguage) {
		this.isLanguage = isLanguage;
	}

	public String getMp_id() {
		return mp_id;
	}

	public void setMp_id(String mp_id) {
		this.mp_id = mp_id;
	}
	
	@SuppressWarnings("unchecked")
	public String toJsonString() {

		String content;
		JSONObject objectManager = new JSONObject();

		objectManager.put("code", code);
		objectManager.put("name", name);
		objectManager.put("duration", duration);
		objectManager.put("isProject", isProject);
		objectManager.put("isSintesis", isSintesis);
		objectManager.put("isFct", isFct);
		objectManager.put("isLanguage", isLanguage);
		objectManager.put("mp_id", mp_id);

		content = objectManager.toJSONString();
		return content;
	}
}