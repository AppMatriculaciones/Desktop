package tests;

import java.util.ArrayList;

import data_access.DaoI;
import data_access.DaoImpl;
import data_access.GenerateHttpRequest;
import models.Student;
import models.Tutor;

public class TestCrudStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*GenerateHttpRequest.get("/students/get/CFPS    ICB0");
		System.out.println();
		GenerateHttpRequest.get("/students/get/CFPS    ICB0&CFPS    ICC0");
		System.out.println();
		GenerateHttpRequest.get("/student/getbydocid/63354180J");*/
		
		DaoI daoI = new DaoImpl();
		
		Student student = daoI.getStudentByDocId("63354180J"); 
		System.out.println(student.toString());
		System.out.println(student.getAddress().toString());
		System.out.println(student.getBirthplace().toString());
		System.out.println(student.getDocument_id().toString());
		System.out.println(student.getFormer_studies().toString());
		System.out.println(student.getRequirements_profile_id());
		for(Tutor t: student.getTutors()) {
			System.out.println(t.toString());
		}
		System.out.println();
		ArrayList<Student> students = daoI.getStudentsByCareersCode("CFPS    ICB0&CFPS    ICC0");
		for(Student s: students) {
			System.out.println(s.getName());
		}
	}

}
