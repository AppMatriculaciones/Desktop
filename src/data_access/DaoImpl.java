package data_access;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
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
			body = objectMapper.writeValueAsString(newCareer);
			String careerId = GenerateHttpRequest.post("/career/create", body);
			newCareer.set_id(careerId);
			System.out.println("Career created: ");
			System.out.println(newCareer.getCode());
			return newCareer;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while parsing Object to Json");
		}
		return null;
	}

	@Override
	public Career getCareer(String careerCode) {
		String body = GenerateHttpRequest.get("career/get/"+careerCode);
		try {
			Career career = objectMapper.readValue(body, Career.class);
			return career;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Career> getCareers() {
		String body = GenerateHttpRequest.get("careers/get");
		try {
			ArrayList<Career> careers = (ArrayList<Career>) objectMapper.readValue(body, new TypeReference<List<Career>>() {});
			return careers;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mp createMp(Mp newMp) {
		// TODO Auto-generated method stub
		try {
			String body = objectMapper.writeValueAsString(newMp);
			String mpId = GenerateHttpRequest.post("/mp/create", body);
			newMp.set_id(mpId);
			System.out.println("Mp created: ");
			System.out.println(newMp.getCode());
			return newMp;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while converting Object to Json.");
		}
		return null;
	}

	@Override
	public Mp getMp(String mpCode) {
		// TODO Auto-generated method stub
		String body = GenerateHttpRequest.get("mp/get/"+mpCode);
		try {
			Mp mp = objectMapper.readValue(body, Mp.class);
			return mp;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Mp> getMpsByCareer(String careerCode) {
		// TODO Auto-generated method stub
		String body = GenerateHttpRequest.get("/mps/getbycareer/"+careerCode);
		try {
			ArrayList<Mp> mps = (ArrayList<Mp>) objectMapper.readValue(body, new TypeReference<List<Mp>>() {});
			return mps;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Uf createUf(Uf newUf) {
		// TODO Auto-generated method stub
		try {
			String body = objectMapper.writeValueAsString(newUf);
			String ufId = GenerateHttpRequest.post("/uf/create", body);
			newUf.set_id(ufId);
			System.out.println("Uf created: ");
			System.out.println(newUf.getCode());
			return newUf;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error while converting Object to Json.");
		}
		return null;
	}

	@Override
	public Uf getUf(String ufCode) {
		String body = GenerateHttpRequest.get("/uf/get/"+ufCode);
		try {
			Uf uf = objectMapper.readValue(body, Uf.class);
			return uf;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Uf> getUfsByMp(String mpCode) {
		String body = GenerateHttpRequest.get("/ufs/getbymp/"+mpCode);
		try {
			ArrayList<Uf> ufs = (ArrayList<Uf>) objectMapper.readValue(body, new TypeReference<List<Uf>>() {});
			return ufs;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Uf> getUfByCareer(String careerCode) {
		String body = GenerateHttpRequest.get("/ufs/getbycareer/"+careerCode);
		try {
			ArrayList<Uf> ufs = (ArrayList<Uf>) objectMapper.readValue(body, new TypeReference<List<Uf>>() {});
			return ufs;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while converting Json to Object.");
			e.printStackTrace();
		}
		return null;
	}
}
