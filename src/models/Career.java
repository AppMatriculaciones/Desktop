package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import data_access.CustomDateSerializer;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Career {

	String _id;
	String code;
	String name;
	int code_educational;
	int hours;
	@JsonSerialize(using = CustomDateSerializer.class)
	Date date_start;
	@JsonSerialize(using = CustomDateSerializer.class)
	Date date_end;
	String family;
	Boolean isDual;
	
	public Career(String _id, String code, String name, int code_educational, int hours, Date date_start, Date date_end,
			String family, Boolean isDual) {
		super();
		this._id = _id;
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
		this.date_start = (Date) jsonCareer.get("date_start");
		this.date_end = (Date) jsonCareer.get("date_end");
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

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
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
	public String toJsonString() throws ParseException {

		String content;
		JSONObject objectManager = new JSONObject();

		objectManager.put("code", code);
		objectManager.put("name", name);
		objectManager.put("code_educational", code_educational);
		objectManager.put("hours", hours);
		if(date_start == null) {
			objectManager.put("date_start", null);
		}else {
			objectManager.put("date_start", new SimpleDateFormat("yyyy-MM-dd").format(date_start));
		}
		if(date_end == null) {
			objectManager.put("date_end", null);
		}else {
			objectManager.put("date_end", new SimpleDateFormat("yyyy-MM-dd").format(date_end));
		}
		objectManager.put("family", family);
		objectManager.put("isDual", isDual);

		content = objectManager.toJSONString();
		return content;
	}
}
