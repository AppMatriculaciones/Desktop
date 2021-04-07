package tests;

import java.util.ArrayList;

import data_access.DaoI;
import data_access.DaoImpl;
import models.Career;
import models.Mp;

public class TestCrudCareers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoI daoI = new DaoImpl();
		
		ArrayList<Career> careers = daoI.getCareers();
		
		for(Career c: careers) {
			System.out.println(c.get_id());
			System.out.println(c.getCode());
			System.out.println(c.getName());
			System.out.println(c.getDate_start());
		}
		
		ArrayList<Mp> mps = daoI.getMpsByCareer("CFPM    AF10");
		
		for(Mp m: mps) {
			System.out.println(m.get_id());
			System.out.println(m.getCode());
			System.out.println(m.getDate_start());
			System.out.println(m.getCareer_id());
		}
	}

}
