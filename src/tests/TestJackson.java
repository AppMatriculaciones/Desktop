package tests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Career;

public class TestJackson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test object to stringJson
		System.out.println("Test object to stringJson");
		ObjectMapper objectMapper = new ObjectMapper();
		Career careerObject = new Career("604d0322aa3e991914dbb252", "CFPS    ICB0",
				"Desenvolupament d'aplicacions multiplataforma", 0, 2000, new Date(), new Date(), "Comunicaciones",
				true);

		try {
			String careerStringFromObject = objectMapper.writeValueAsString(careerObject);
			System.out.println(careerStringFromObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Test stringJson to object
		System.out.println("Test stringJson to object");
		String careerString = "{\"_id\":\"604d0322aa3e991914dbb252\",\"code\":\"CFPS ICB0\",\"name\":\"Desenvolupament d'aplicacions multiplataforma\",\"code_educational\":\"0\",\"hours\":2000,\"date_start\":\"2021-09-08T22:00:00.000Z\",\"date_end\":\"2022-06-15T22:00:00.000Z\",\"family\":\"Comunicaciones\",\"isDual\":true}";
		//String careerString = "{\"_id\":\"604d0322aa3e991914dbb252\",\"code\":\"CFPS    ICB0\",\"name\":\"Desenvolupament d'aplicacions multiplataforma\",\"code_educational\":\"0\",\"hours\":2000,\"date_start\":\"1617738000187\",\"date_end\":\"1617738000187\",\"family\":\"Comunicaciones\",\"isDual\":true}";

		try {
			Career careerFromJson = objectMapper.readValue(careerString, Career.class);
			System.out.println(careerFromJson.getCode() + " " + careerFromJson.getName()+" "+careerFromJson.getDate_start());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(formatter.format(careerFromJson.getDate_start()));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Test arrayStringJson to ArrayListObject
		System.out.println("Test arrayStringJson to ArrayListObject");
		String careersString = "[{\"_id\":\"604d0322aa3e991914dbb253\",\"code\":\"CFPS    ICB0\",\"name\":\"Desenvolupament d'aplicacions Web\",\"code_educational\":\"0\",\"hours\":2000,\"date_start\":\"1617738000187\",\"date_end\":\"1617738000187\",\"family\":\"Comunicaciones\",\"isDual\":true},{\"_id\":\"604d0322aa3e991914dbb252\",\"code\":\"CFPS    ICB0\",\"name\":\"Desenvolupament d'aplicacions multiplataforma\",\"code_educational\":\"0\",\"hours\":2000,\"date_start\":\"1617738000187\",\"date_end\":\"1617738000187\",\"family\":\"Comunicaciones\",\"isDual\":true}]";
		try {
			ArrayList<Career> careersFromJsonArray = (ArrayList<Career>) objectMapper.readValue(careersString,
					new TypeReference<List<Career>>() {
					});
			for (Career c : careersFromJsonArray) {
				System.out.println(c.getName());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(formatter.format(c.getDate_start()));
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
