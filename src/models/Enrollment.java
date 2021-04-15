package models;

import java.sql.Date;
import java.util.ArrayList;

public class Enrollment {
	private String _id;
	private Date start_date;
	private Date end_date;
	private Boolean isOpen;
	private String status;
	private ArrayList<String> requirements;
	private ArrayList<String> ufs_id;
	private String student_id;
	private String carrer_id;
	private String convocation;
	private String solicitation_code;
	private String regimen;
	private String turn;
	private String solicitation_Type;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(String _id, Date start_date, Date end_date, Boolean isOpen, String status,
			ArrayList<String> requirements, ArrayList<String> ufs_id, String student_id, String carrer_id,
			String convocation, String solicitation_code, String regimen, String turn, String solicitation_Type) {
		super();
		this._id = _id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isOpen = isOpen;
		this.status = status;
		this.requirements = requirements;
		this.ufs_id = ufs_id;
		this.student_id = student_id;
		this.carrer_id = carrer_id;
		this.convocation = convocation;
		this.solicitation_code = solicitation_code;
		this.regimen = regimen;
		this.turn = turn;
		this.solicitation_Type = solicitation_Type;
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

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<String> requirements) {
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

	public String getCarrer_id() {
		return carrer_id;
	}

	public void setCarrer_id(String carrer_id) {
		this.carrer_id = carrer_id;
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

	public String getSolicitation_Type() {
		return solicitation_Type;
	}

	public void setSolicitation_Type(String solicitation_Type) {
		this.solicitation_Type = solicitation_Type;
	}

}
