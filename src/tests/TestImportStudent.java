package tests;

import java.io.File;

import import_data.ImportStudent;

public class TestImportStudent {
	public static void main(String[] args) {
		File csv = new File("C:\\Users\\susom\\Desktop\\AppMatriculacions\\testAddAlumnes.csv");
		ImportStudent importstudent = new ImportStudent();
		importstudent.readAlumns(csv);
	}
}
