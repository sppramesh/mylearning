package com.learning.myapp.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.learning.myapp.common.PersistenceManager;
import com.learning.myapp.dto.PersonDTO;
import com.learning.myapp.entity.Person;

@Path("/person")
public class PersonApi {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("all")
	public Response getAllPerson(){
		PersonDTO dto1 = new PersonDTO();
		dto1.setFirstName("Rameshkumar");
		dto1.setLastName("Palaniappan");
		
		PersonDTO dto2 = new PersonDTO();
		dto2.setFirstName("Jack");
		dto2.setLastName("Rob");
		
		PersonDTO dto3 = new PersonDTO();
		dto3.setFirstName("Peter");
		dto3.setLastName("Pot");

		ArrayList persons = new ArrayList();
		persons.add(dto1);
		persons.add(dto2);
		persons.add(dto3);
		return Response.ok(dto1).build();
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all/json")
	public Response getAllPersonJSON() throws Exception{
		
		
		EntityManagerFactory managerFactory = PersistenceManager.getInstance().getEntityManagerFactory();
        EntityManager em = managerFactory.createEntityManager();
        final Session session = (Session)em.getDelegate();
        List list = null;
        try {
        	final Criteria criteria = session.createCriteria(Person.class);
	    	list = criteria.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
        
		return Response.ok(list).build();
		
	}
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
	public Response save(PersonDTO person) throws Exception{
    	
    	   	
    	 EntityManagerFactory managerFactory = PersistenceManager.getInstance().getEntityManagerFactory();
         EntityManager em = managerFactory.createEntityManager();
         EntityTransaction tran = em.getTransaction();
         try {
			tran.begin();
			Person personEntity = new Person();

	    	personEntity.setFirstName(person.getFirstName());
	    	personEntity.setLastName(person.getLastName());
	    	em.merge(personEntity);
	    	tran.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
         
    	return Response.ok().build();
		
	}
}
