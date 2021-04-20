package import_data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data_access.DaoI;
import data_access.DaoImpl;
import models.Address;
import models.Birthplace;
import models.DocumentId;
import models.FormerStudies;
import models.Student;
import models.Tutor;

public class ImportStudent {

	private File csv;

	public void readAlumns(File csv) {
		String line;
		String[] lineSplit;
		Student st = new Student();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(csv));
			bf.readLine();
			while (bf.ready()) {
				line = bf.readLine();
				lineSplit = line.split(",");
				st.setName(lineSplit[4]);
				st.setFirst_surname(lineSplit[5]);
				st.setSecond_surname(lineSplit[6]);
				st.setRalc_id(lineSplit[7]);
				st.setStudentType(lineSplit[8]);

				// Student Documents
				DocumentId dc = new DocumentId();
				if (lineSplit[21].equals("DNI")) {
					dc.setId(lineSplit[21]);
					dc.setType("DNI");
				} else if (lineSplit[22].equals("NIE")) {
					dc.setId(lineSplit[22]);
					dc.setType("NIE");
				} else if (lineSplit[23].equals("PASS")) {
					dc.setId(lineSplit[23]);
					dc.setType("PASS");
				} else if (lineSplit[24].equals("TIS")) {
					dc.setId(lineSplit[24]);
					dc.setType("TIS");
				}
				st.setDocument_id(dc);
				st.setBirthday(ParseFecha(lineSplit[25]));
				st.setSex(lineSplit[26]);

				// Bithplace Student
				Birthplace bp = new Birthplace();
				bp.setCountry(lineSplit[27]);
				bp.setCity(lineSplit[29]);
				st.setBirthplace(bp);

				// Adress Student
				Address ad = new Address();
				ad.setType(lineSplit[30]);
				ad.setName(lineSplit[31]);
				ad.setNumber(lineSplit[32]);
				ad.setOthers(lineSplit[33]);
				ad.setState(lineSplit[34]);
				ad.setCity(lineSplit[35]);
				ad.setDistrict(lineSplit[36]);
				ad.setCp(lineSplit[37]);
				ad.setCountry(lineSplit[38]);
				st.setAddress(ad);

				st.setPhone(Integer.parseInt(lineSplit[39]));
				st.setEmail(lineSplit[40]);

				// Tutor 1
				ArrayList<Tutor> tutors = new ArrayList<Tutor>();;
				Tutor tut = new Tutor();
				dc.setType(lineSplit[41]);
				dc.setId(lineSplit[42]);
				tut.setDocument_id(dc);
				tut.setName(lineSplit[43]);
				tut.setFirst_surname(lineSplit[44]);
				tut.setSecond_surname(lineSplit[45]);
				tutors.add(tut);
				
				// Tutor 2
				Tutor tut2 = new Tutor();
				dc.setType(lineSplit[46]);
				dc.setId(lineSplit[47]);
				tut2.setDocument_id(dc);
				tut2.setName(lineSplit[48]);
				tut2.setFirst_surname(lineSplit[49]);
				tut2.setSecond_surname(lineSplit[50]);
				st.setTutors(null);
				tutors.add(tut2);

				st.setTutors(tutors);

				FormerStudies fs = new FormerStudies();
				fs.setSchool_code(lineSplit[51]);
				fs.setSchool_name(lineSplit[52]);
				fs.setCourse_code(lineSplit[53]);
				fs.setCourse_name(lineSplit[54]);
				fs.setCourse_proc(lineSplit[55]);

				st.setFormer_studies(fs);
				st.setRequirements_profile_id(null);
				st.setLanguages(lineSplit[56]);
				st.setReligion(lineSplit[57]);

			}
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while creating bf.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error related to bf.readLine()");
		}
		importStudents(st);
	}

	public void importStudents(Student student) {
		DaoI daoi = new DaoImpl();
		student = daoi.createStudent(student);
	}

	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return fechaDate;
	}
}
