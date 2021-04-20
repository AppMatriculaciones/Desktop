package models;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import data_access.CustomDateSerializer;

public class Student {

	@JsonProperty(access = Access.WRITE_ONLY)
	private String _id;
	private String name;
	private String first_surname;
	private String second_surname;
	private String email;
	private String password;
	private String token;
	private int phone;
	private ArrayList<String> ufs_completed = new ArrayList<String>();
	private String ralc_id;
	private DocumentId document_id;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date birthday;
	private Address address;
	private Birthplace birthplace;
	private String nationality;
	private String sex;
	private ArrayList<Tutor> tutors = new ArrayList<Tutor>();
	private FormerStudies former_studies;
	private String languages;
	private String religion;
	private String requirements_profile_id;
	private String studentType;

	public Student(String name, String first_surname, String second_surname, String email, String password,
			String token, int phone, ArrayList<String> ufs_completed, String ralc_id, DocumentId document_id,
			Date birthday, Address address, Birthplace birthplace, String nationality, String sex,
			ArrayList<Tutor> tutors, FormerStudies former_studies, String languages, String religion,
			String requirements_profile_id, String studentType) {
		super();
		this.name = name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
		this.email = email;
		this.password = password;
		this.token = token;
		this.phone = phone;
		this.ufs_completed = ufs_completed;
		this.ralc_id = ralc_id;
		this.document_id = document_id;
		this.birthday = birthday;
		this.address = address;
		this.birthplace = birthplace;
		this.nationality = nationality;
		this.sex = sex;
		this.tutors = tutors;
		this.former_studies = former_studies;
		this.languages = languages;
		this.religion = religion;
		this.requirements_profile_id = requirements_profile_id;
		this.studentType = studentType;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public ArrayList<String> getUfs_completed() {
		return ufs_completed;
	}

	public void setUfs_completed(ArrayList<String> ufs_completed) {
		this.ufs_completed = ufs_completed;
	}

	public String getRalc_id() {
		return ralc_id;
	}

	public void setRalc_id(String ralc_id) {
		this.ralc_id = ralc_id;
	}

	public DocumentId getDocument_id() {
		return document_id;
	}

	public void setDocument_id(DocumentId document_id) {
		this.document_id = document_id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Birthplace getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(Birthplace birthplace) {
		this.birthplace = birthplace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public ArrayList<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(ArrayList<Tutor> tutors) {
		this.tutors = tutors;
	}

	public FormerStudies getFormer_studies() {
		return former_studies;
	}

	public void setFormer_studies(FormerStudies former_studies) {
		this.former_studies = former_studies;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRequirements_profile_id() {
		return requirements_profile_id;
	}

	public void setRequirements_profile_id(String requirements_profile_id) {
		this.requirements_profile_id = requirements_profile_id;
	}

	@Override
	public String toString() {
		return document_id.getId() + " " + name + " " + first_surname + " " + second_surname;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

}
