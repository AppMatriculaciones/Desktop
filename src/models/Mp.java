package models;

import java.util.Date;

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
}
