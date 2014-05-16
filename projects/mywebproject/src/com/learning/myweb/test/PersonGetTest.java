package com.learning.myweb.test;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.learning.myweb.bean.PersonBean;
import com.learning.myweb.service.PersonService;

public class PersonGetTest {
	
	
	
	public static void main(String[] args) {
	
		PersonService service = new PersonService();
		try {
			List <PersonBean> persons = service.getPersons();
			System.out.println(persons);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
}
