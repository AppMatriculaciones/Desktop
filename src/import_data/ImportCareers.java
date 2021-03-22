package import_data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data_access.DaoI;
import data_access.DaoImpl;
import models.Career;
import models.Mp;
import models.Uf;

public class ImportCareers {
	
	private File csv;
	private ArrayList<String> selectedCareersCode = new ArrayList<String>();
	private ArrayList<String> careersCode = new ArrayList<String>();
	private ArrayList<String> careersName = new ArrayList<String>();
	private String lastCareerRead = "", lastMpRead = "", lastUfRead = "";
	
	public ImportCareers(File csv) {
		super();
		this.csv = csv;
	}
		
	public File getCsv() {
		return csv;
	}

	public void setCsv(File csv) {
		this.csv = csv;
	}

	public ArrayList<String> getSelectedCareersCode() {
		return selectedCareersCode;
	}

	public void setSelectedCareersCode(ArrayList<String> selectedCareersCode) {
		this.selectedCareersCode = selectedCareersCode;
	}

	public ArrayList<String> getCareersCode() {
		return careersCode;
	}

	public void setCareersCode(ArrayList<String> careersCode) {
		this.careersCode = careersCode;
	}

	public ArrayList<String> getCareersName() {
		return careersName;
	}

	public void setCareersName(ArrayList<String> careersName) {
		this.careersName = careersName;
	}

	public void readCareers() {
		String line;
		String[] lineSplit;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(csv));
			bf.readLine();
			while(bf.ready()) {
				line = bf.readLine();
				lineSplit = line.split(",");
				if(!lineSplit[0].equals(lastCareerRead)) {
					lastCareerRead = lineSplit[0];
					careersCode.add(lineSplit[0]);
					careersName.add(lineSplit[1]);
				}
			}
			bf.close();
			lastCareerRead = "";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while creating bf.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error related to bf.readLine()");
		}
	}
	
	public void importData() throws ParseException {
		String line;
		String[] lineSplit;
		DaoI daoI = new DaoImpl();
		try {
			Career newCareer = new Career();
			Mp newMp = new Mp();
			Uf newUf = new Uf();
			BufferedReader bf = new BufferedReader(new FileReader(csv));
			bf.readLine();
			while(bf.ready()) {
				line = bf.readLine();
				lineSplit = line.split(",");
				
				if(isCareerSelected(lineSplit[0])) {
					if(!lineSplit[0].equals(lastCareerRead)) {
						lastCareerRead = lineSplit[0];
						newCareer.setCode(lineSplit[0]);
						newCareer.setName(lineSplit[1]);
						newCareer.setCode_educational(Integer.valueOf(lineSplit[2]));
						newCareer.setHours(Integer.valueOf(lineSplit[3]));
						/*newCareer.setDate_start(new SimpleDateFormat("dd/MM/yyyy").parse(lineSplit[4]));
						if(!lineSplit[5].equals("")) {
							newCareer.setDate_end(new SimpleDateFormat("dd/MM/yyyy").parse(lineSplit[5]));
						}*/
						newCareer = daoI.createCareer(newCareer);
						
					}
					if(!lineSplit[6].equals(lastMpRead)) {
						lastMpRead = lineSplit[6];
						newMp.setCode(lineSplit[6]);
						newMp.setName(lineSplit[7]);
						newMp.setDuration_min(Integer.valueOf(lineSplit[8]));
						newMp.setDuration_max(Integer.valueOf(lineSplit[9]));
						/*newMp.setDate_start(new SimpleDateFormat("dd/MM/yyyy").parse(lineSplit[11]));
						if(!lineSplit[12].equals("")) {
							newMp.setDate_end(new SimpleDateFormat("dd/MM/yyyy").parse(lineSplit[12]));
						}*/
						newMp.setCareer_id(newCareer.get_id());
						newMp = daoI.createMp(newMp);
					}
					if(!lineSplit[12].equals(lastUfRead)) {
						lastUfRead = lineSplit[12];
						newUf.setCode(lineSplit[12]);
						newUf.setName(lineSplit[13]);
						newUf.setDuration(Integer.valueOf(lineSplit[14]));
						if(lineSplit[15].equals("N")) {
							newUf.setIsFct(false);
						}else {
							newUf.setIsFct(true);
						}
						if(lineSplit[16].equals("N")) {
							newUf.setIsSintesis(false);
						}else {
							newUf.setIsSintesis(true);
						}
						if(lineSplit[17].equals("N")) {
							newUf.setIsLanguage(false);
						}else {
							newUf.setIsLanguage(true);
						}
						if(lineSplit[18].equals("N")) {
							newUf.setIsProject(false);
						}else {
							newUf.setIsProject(true);
						}
						newUf.setMp_id(newMp.get_id());
						newUf = daoI.createUf(newUf);
					}
				}
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
	}
	
	private boolean isCareerSelected(String careerCode) {
		for(int i = 0; i < selectedCareersCode.size(); i++) {
			if(careerCode.equals(selectedCareersCode.get(i))){
				return true;
			}
		}
		return false;
	}
}
