package com.learning.myweb.test;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.learning.myweb.dto.PersonDTO;
import com.learning.myweb.service.PersonService;

public class PersonSaveTest {
	
	
	
	public static void main(String[] args) {
	
		PersonService service = new PersonService();
		
		PersonDTO person = new PersonDTO();
		person.setFirstName("saveFirstName");
		person.setLastName("saveLastName");
		try {
			String status = service.save(person);
			System.out.println(status);
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
