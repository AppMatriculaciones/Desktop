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
		ArrayList<String> lineSplit;
		DaoI daoI = new DaoImpl();
		try {
			Career newCareer = new Career();
			Mp newMp = new Mp();
			Uf newUf = new Uf();
			BufferedReader bf = new BufferedReader(new FileReader(csv));
			bf.readLine();
			while(bf.ready()) {
				line = bf.readLine();
				lineSplit = splitCsvLine2(line);
				
				if(isCareerSelected(lineSplit.get(0))) {
					if(!lineSplit.get(0).equals(lastCareerRead)) {
						lastCareerRead = lineSplit.get(0);
						newCareer.setCode(lineSplit.get(0));
						newCareer.setName(lineSplit.get(1));
						newCareer.setCode_educational(Integer.valueOf(lineSplit.get(2)));
						newCareer.setHours(Integer.valueOf(lineSplit.get(3)));
						newCareer.setDate_start(new SimpleDateFormat("dd-MM-yyyy").parse(lineSplit.get(4).replaceAll("/", "-")));
						if(!lineSplit.get(5).equals("")) {
							newCareer.setDate_end(new SimpleDateFormat("dd-MM-yyyy").parse(lineSplit.get(5).replaceAll("/", "-")));
						}else {
							newCareer.setDate_end(null);
						}
						newCareer = daoI.createCareer(newCareer);
						
					}
					if(!lineSplit.get(6).equals(lastMpRead)) {
						lastMpRead = lineSplit.get(6);
						newMp.setCode(lineSplit.get(6));
						newMp.setName(lineSplit.get(7));
						newMp.setDuration_min(Integer.valueOf(lineSplit.get(8)));
						newMp.setDuration_max(Integer.valueOf(lineSplit.get(9)));
						newMp.setDate_start(new SimpleDateFormat("dd-MM-yyyy").parse(lineSplit.get(10).replaceAll("/", "-")));
						if(!lineSplit.get(11).equals("")) {
							newMp.setDate_end(new SimpleDateFormat("dd-MM-yyyy").parse(lineSplit.get(11).replaceAll("/", "-")));
						}else {
							newMp.setDate_end(null);
						}
						newMp.setCareer_id(newCareer.get_id());
						newMp = daoI.createMp(newMp);
					}
					if(!lineSplit.get(12).equals(lastUfRead)) {
						lastUfRead = lineSplit.get(12);
						newUf.setCode(lineSplit.get(12));
						newUf.setName(lineSplit.get(13));
						newUf.setDuration(Integer.valueOf(lineSplit.get(14)));
						if(lineSplit.get(15).equals("N")) {
							newUf.setIsFct(false);
						}else {
							newUf.setIsFct(true);
						}
						if(lineSplit.get(16).equals("N")) {
							newUf.setIsSintesis(false);
						}else {
							newUf.setIsSintesis(true);
						}
						if(lineSplit.get(17).equals("N")) {
							newUf.setIsLanguage(false);
						}else {
							newUf.setIsLanguage(true);
						}
						if(lineSplit.get(18).equals("N")) {
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
	
	public ArrayList<String> splitCsvLine(String line){
		ArrayList<String> split = new ArrayList<String>();
		//ArrayList<String> split2 = new ArrayList<String>();
		//ArrayList<String> split3 = new ArrayList<String>();
		
		String[] splitString1 = line.split(",\"");
		
		for(int i = 0; i < splitString1.length; i++) {
			String[] splitString2 = splitString1[i].split("\",");
			for(int j = 0; j < splitString2.length; j++) {
				String[] splitString3 = splitString2[j].split(",");
				for(int k = 0; k < splitString3.length; k++) {
					split.add(splitString3[k]);
				}
			}
		}
		/*for(int i = 0; i < splitString1.length; i++) {
			split1.add(splitString1[i]);
		}
		
		for(int i = 0; i < split1.size(); i++) {
			String[] splitString2 = split1.get(i).split("\",");
			for(int j = 0; j < splitString2.length; j++) {
				split2.add(splitString2[j]);
			}
		}
		
		for(int i = 0; i < split2.size(); i++) {
			String[] splitString3 = split1.get(i).split(",");
			for(int j = 0; j < splitString3.length; j++) {
				split2.add(splitString3[j]);
			}
		}*/
		for(int i = 0; i < split.size(); i++) {
			System.out.println(split.get(i));
		}
		
		return split;
	}
	
	public static ArrayList<String> splitCsvLine2(String line){
		boolean ignoreComma = true;
		String column = "";
		ArrayList<String> columns = new ArrayList<String>();
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '\"') {
				ignoreComma = !ignoreComma;
			}else {
				if(line.charAt(i) == ',' && ignoreComma == true) {
					columns.add(column);
					column = "";
				}else {
					column = column+line.charAt(i);
				}
			}
		}
		columns.add(column);
		return columns;	
	}
}
