package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import data_access.CustomDateSerializer;

@JsonIgnoreProperties(value = { "_id" })
public class Mp {

	String _id;
	String code;
	String name;
	int duration_min;
	int duration_max;
	@JsonSerialize(using = CustomDateSerializer.class)
	Date date_start;
	@JsonSerialize(using = CustomDateSerializer.class)
	Date date_end;
	String career_id;
	
	public Mp(String code, String name, int duration_min, int duration_max, Date date_start, Date date_end, String career_id) {
		super();
		this.code = code;
		this.name = name;
		this.duration_min = duration_min;
		this.duration_max = duration_max;
		this.date_start = date_start;
		this.date_end = date_end;
		this.career_id = career_id;
	}
	
	public Mp(JSONObject jsonMP) {
		super();
		this.code = (String) jsonMP.get("code");
		this.name = (String) jsonMP.get("name");
		this.duration_min = (int) jsonMP.get("duration_min");
		this.duration_max = (int) jsonMP.get("duration_max");
		this.date_start = (Date) jsonMP.get("date_start");
		this.date_end = (Date) jsonMP.get("date_end");
		this.career_id = (String) jsonMP.get("career_id");
	}
	
	public Mp() {
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

	public int getDuration_min() {
		return duration_min;
	}

	public void setDuration_min(int duration_min) {
		this.duration_min = duration_min;
	}

	public int getDuration_max() {
		return duration_max;
	}

	public void setDuration_max(int duration_max) {
		this.duration_max = duration_max;
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

	public String getCareer_id() {
		return career_id;
	}

	public void setCareer_id(String career_id) {
		this.career_id = career_id;
	}
	
	@SuppressWarnings("unchecked")
	public String toJsonString() {

		String content;
		JSONObject objectManager = new JSONObject();

		objectManager.put("code", code);
		objectManager.put("name", name);
		objectManager.put("duration_min", duration_min);
		objectManager.put("duration_max", duration_max);
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
		objectManager.put("career_id", career_id);

		content = objectManager.toJSONString();
		return content;
	}
}
