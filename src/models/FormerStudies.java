package models;

public class FormerStudies {

	private String school_code;
	private String school_name;
	private String course_code;
	private String course_name;
	private String course_proc;
	
	public FormerStudies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormerStudies(String school_code, String school_name, String course_code, String course_name,
			String course_proc) {
		super();
		this.school_code = school_code;
		this.school_name = school_name;
		this.course_code = course_code;
		this.course_name = course_name;
		this.course_proc = course_proc;
	}

	public String getSchool_code() {
		return school_code;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_proc() {
		return course_proc;
	}

	public void setCourse_proc(String course_proc) {
		this.course_proc = course_proc;
	}

	@Override
	public String toString() {
		return "FormerStudies [school_code=" + school_code + ", school_name=" + school_name + ", course_code="
				+ course_code + ", course_name=" + course_name + ", course_proc=" + course_proc + "]";
	}
	
	
}
