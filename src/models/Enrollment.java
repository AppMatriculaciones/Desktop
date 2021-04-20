package models;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import data_access.CustomDateSerializer;

public class Enrollment {
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String _id;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date start_date;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date end_date;
	private boolean isOpen;
	private String status;
	private ArrayList<Requirement> requirements = new ArrayList<Requirement>();
	private ArrayList<String> ufs_id = new ArrayList<String>();
	private String student_id;
	private String career_id;
	private String convocation;
	private String solicitation_code;
	private String regimen;
	private String turn;
	private String solicitation_type;
	
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(String _id, Date start_date, Date end_date, boolean isOpen, String status,
			ArrayList<Requirement> requirements, ArrayList<String> ufs_id, String student_id, String career_id,
			String convocation, String solicitation_code, String regimen, String turn, String solicitation_type) {
		super();
		this._id = _id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isOpen = isOpen;
		this.status = status;
		this.requirements = requirements;
		this.ufs_id = ufs_id;
		this.student_id = student_id;
		this.career_id = career_id;
		this.convocation = convocation;
		this.solicitation_code = solicitation_code;
		this.regimen = regimen;
		this.turn = turn;
		this.solicitation_type = solicitation_type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<Requirement> requirements) {
		this.requirements = requirements;
	}

	public ArrayList<String> getUfs_id() {
		return ufs_id;
	}

	public void setUfs_id(ArrayList<String> ufs_id) {
		this.ufs_id = ufs_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getCareer_id() {
		return career_id;
	}

	public void setCareer_id(String career_id) {
		this.career_id = career_id;
	}

	public String getConvocation() {
		return convocation;
	}

	public void setConvocation(String convocation) {
		this.convocation = convocation;
	}

	public String getSolicitation_code() {
		return solicitation_code;
	}

	public void setSolicitation_code(String solicitation_code) {
		this.solicitation_code = solicitation_code;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getSolicitation_type() {
		return solicitation_type;
	}

	public void setSolicitation_type(String solicitation_type) {
		this.solicitation_type = solicitation_type;
	}

	@Override
	public String toString() {
		return "Enrollment [_id=" + _id + ", start_date=" + start_date + ", end_date=" + end_date + ", isOpen=" + isOpen
				+ ", status=" + status + ", requirements=" + requirements + ", ufs_id=" + ufs_id + ", student_id="
				+ student_id + ", career_id=" + career_id + ", convocation=" + convocation + ", solicitation_code="
				+ solicitation_code + ", regimen=" + regimen + ", turn=" + turn + ", solicitation_type="
				+ solicitation_type + "]";
	}
}
