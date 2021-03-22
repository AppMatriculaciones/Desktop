package models;

import java.util.Date;

import org.json.simple.JSONObject;

public class Career {

	String _id;
	String code;
	String name;
	int code_educational;
	int hours;
	String date_start = "2021-03-03";
	String date_end = "2021-03-03";
	String family;
	Boolean isDual;
	
	public Career(String code, String name, int code_educational, int hours, String date_start, String date_end,
			String family, Boolean isDual) {
		super();
		this.code = code;
		this.name = name;
		this.code_educational = code_educational;
		this.hours = hours;
		this.date_start = date_start;
		this.date_end = date_end;
		this.family = family;
		this.isDual = isDual;
	}
	
	public Career(JSONObject jsonCareer) {
		super();
		this.code = (String) jsonCareer.get("code");
		this.name = (String) jsonCareer.get("name");
		this.code_educational = (int) jsonCareer.get("code_educational");
		this.hours = (int) jsonCareer.get("hours");
		this.date_start = (String) jsonCareer.get("date_start");
		this.date_end = (String) jsonCareer.get("date_end");
		this.family = (String) jsonCareer.get("family");
		this.isDual = (Boolean) jsonCareer.get("isDual");
	}
	
	public Career() {
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

	public int getCode_educational() {
		return code_educational;
	}

	public void setCode_educational(int code_educational) {
		this.code_educational = code_educational;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Boolean getIsDual() {
		return isDual;
	}

	public void setIsDual(Boolean isDual) {
		this.isDual = isDual;
	}
	
	@SuppressWarnings("unchecked")
	public String toJsonString() {

		String content;
		JSONObject objectManager = new JSONObject();

		objectManager.put("code", code);
		objectManager.put("name", name);
		objectManager.put("code_educational", code_educational);
		objectManager.put("hours", hours);
		objectManager.put("date_start", date_start);
		objectManager.put("date_end", date_end);
		objectManager.put("family", family);
		objectManager.put("isDual", isDual);

		content = objectManager.toJSONString();
		return content;
	}
}
