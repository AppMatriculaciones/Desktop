package models;

import java.util.Date;
import data_access.CustomDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(value = { "_id" })
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
}
