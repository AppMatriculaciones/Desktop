package data_access;

import java.util.ArrayList;

import models.Career;
import models.Mp;
import models.Uf;


public class DaoImpl implements DaoI{

	@Override
	public Career createCareer(Career newCareer) {
		// TODO Auto-generated method stub
		String body = newCareer.toJsonString();
		String careerId = GenerateHttpRequest.post("/career/create", body);
		newCareer.set_id(careerId);
		System.out.println("Career created: ");
		System.out.println(newCareer.toString());
		return newCareer;
	}

	@Override
	public Career getCareer(String careerCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Career> getCareers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mp createMp(Mp newMp) {
		// TODO Auto-generated method stub
		String mpId = GenerateHttpRequest.post("/mp/create", newMp.toJsonString());
		newMp.set_id(mpId);
		System.out.println("Mp created: ");
		System.out.println(newMp.toString());
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
		System.out.println(newUf.toString());
		return newUf;
	}

	@Override
	public Uf getUf(String ufCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Uf> getUfsByMp(String mpCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Uf> getUfByCareer(String careerCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
