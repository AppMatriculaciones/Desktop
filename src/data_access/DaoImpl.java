package data_access;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Career;
import models.Mp;
import models.Uf;

public class DaoImpl implements DaoI {
	private static ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public Career createCareer(Career newCareer) {
		String body;
		try {
			body = newCareer.toJsonString();
			String careerId = GenerateHttpRequest.post("/career/create", body);
			newCareer.set_id(careerId);
			System.out.println("Career created: ");
			System.out.println(newCareer.getCode());
			return newCareer;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Career getCareer(String careerCode) {
		
		return null;
	}

	@Override
	public ArrayList<Career> getCareers() {
		String stringCareers = GenerateHttpRequest.get("/careers/get");
		ArrayList<Career> careers = stringToObjectCareers(stringCareers);
		return careers;
	}

	@Override
	public Mp createMp(Mp newMp) {
		// TODO Auto-generated method stub
		String mpId = GenerateHttpRequest.post("/mp/create", newMp.toJsonString());
		newMp.set_id(mpId);
		System.out.println("Mp created: ");
		System.out.println(newMp.getCode());
		return newMp;
	}

	@Override
	public Mp getMp(String mpCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mp> getMpsByCareer(String careerCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uf createUf(Uf newUf) {
		// TODO Auto-generated method stub
		String ufId = GenerateHttpRequest.post("/uf/create", newUf.toJsonString());
		newUf.set_id(ufId);
		System.out.println("Uf created: ");
		System.out.println(newUf.getCode());
		return newUf;
	}

	@Override
	public Uf getUf(String ufCode) {
		return null;
	}

	@Override
	public ArrayList<Uf> getUfsByMp(String mpCode) {
		return null;
	}

	@Override
	public ArrayList<Uf> getUfByCareer(String careerCode) {
		String ufByCareer = GenerateHttpRequest.get("/ufs/getbycareer/"+careerCode);
		System.out.println(ufByCareer);
		//falta parsearlo
		return null;
	}
	
	public ArrayList<Career> stringToObjectCareers(String stringCareers){
		ArrayList<String> arrayCareers = stringToArrayString(stringCareers);
		ArrayList<Career> careers = new ArrayList<Career>();
		JSONParser parser = new JSONParser(); 
		for(String stringCareer: arrayCareers) {
			try {
				JSONObject jsonCareer = (JSONObject) parser.parse(stringCareer);
				Career career = new Career(jsonCareer);
				careers.add(career);
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Failed to parse string to Json.");
			}
			
		}
		return careers;
	}
	
	public ArrayList<String> stringToArrayString(String arrayJson){
		boolean ignoreComma = true;
		String json = "";
		ArrayList<String> jsons = new ArrayList<String>();
		
		for(int i = 0; i < arrayJson.length(); i++) {
			if(arrayJson.charAt(i) == '{' || arrayJson.charAt(i) == '}') {
				ignoreComma = !ignoreComma;
			}else if(arrayJson.charAt(i) == '[' || arrayJson.charAt(i) == ']'){
				
			}
			else {
				if(arrayJson.charAt(i) == ',' && ignoreComma == true) {
					json = "{"+json+"}";
					jsons.add(json);
					json = "";
				}else {
					json = json+arrayJson.charAt(i);
				}
			}
		}
		json = "{"+json+"}";
		jsons.add(json);
		return jsons;	
	}

}
