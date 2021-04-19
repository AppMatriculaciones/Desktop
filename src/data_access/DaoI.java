package data_access;

import java.util.ArrayList;

import models.Career;
import models.Mp;
import models.RequirementsProfile;
import models.Student;
import models.Uf;

public interface DaoI {
	
	public Career createCareer(Career newCareer);
	
	public Career getCareer(String careerCode);
	
	public ArrayList<Career> getCareers();
	
	public Mp createMp(Mp newMp);
	
	public Mp getMp(String mpCode);
	
	public ArrayList<Mp> getMpsByCareer(String careerCode);
	
	public Uf createUf(Uf newUf);
	
	public Uf getUf(String ufCode);
	
	public Uf getUfById(String ufId);
	
	public ArrayList<Uf> getUfsByMp(String mpCode);
	
	public ArrayList<Uf> getUfByCareer(String careerCode);
	
	public Student getStudentByDocId(String docId);
	
	public ArrayList<Student> getStudentsByCareersCode(String careersCode);
	
	public ArrayList<Student> getStudents();
	
	public RequirementsProfile getRequirementsProfileById(String id);
	
	public ArrayList<RequirementsProfile> getRequirementsProfile();
	
	public void updateStudentByDocId(Student student);
}
