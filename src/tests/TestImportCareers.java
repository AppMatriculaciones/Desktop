package tests;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import import_data.ImportCareers;

public class TestImportCareers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File csv = new File("C:\\Users\\alecp\\Downloads\\Taules_cataleg_FP_18-19-LOE.csv");
		ImportCareers importCareers = new ImportCareers(csv);
		
		//Test read careers' code and name
		importCareers.readCareers();
		ArrayList<String> careersCode = importCareers.getCareersCode();
		ArrayList<String> careersName = importCareers.getCareersName();
		
		for(int i = 0; i < careersCode.size(); i++) {
			System.out.println(careersCode.get(i)+ " "+careersName.get(i));
		}
		
		/*
		//Test import selected careers
		ArrayList<String> selectedCareersCode = new ArrayList<String>();
		
		selectedCareersCode.add("CFPM    AG10");
		selectedCareersCode.add("CFPM    AG11");
		selectedCareersCode.add("CFPM    AF10");
		selectedCareersCode.add("CFPS    ICB0");
		selectedCareersCode.add("CFPS    ICC0");
		importCareers.setSelectedCareersCode(selectedCareersCode);
		try {
			importCareers.importData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
