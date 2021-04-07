package tests;

import java.util.ArrayList;

import data_access.DaoI;
import data_access.DaoImpl;
import data_access.GenerateHttpRequest;
import models.Career;

public class TestShowCareers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl daoI = new DaoImpl();
		/*
		String careers = GenerateHttpRequest.get("/careers/get");
		ArrayList<String> c = daoI.stringToArrayString(careers);
		for(String s: c) {
			System.out.println(s);
		}*/
		
		ArrayList<Career> careers = daoI.getCareers();
		for(Career career: careers) {
			System.out.println(career.getCode()+" "+career.getName());
		}
	}

}
