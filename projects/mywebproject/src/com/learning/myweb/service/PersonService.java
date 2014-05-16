package com.learning.myweb.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Provider;
import com.learning.myweb.bean.PersonBean;
import com.learning.myweb.dto.PersonDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class PersonService {
String uri="/api/person/all/json";
	String url="http://localhost:8060/myproject/api/person/all/json";

	public List<PersonBean> getPersons() throws JsonParseException, JsonMappingException, IOException{
		
		 ClientConfig config = new DefaultClientConfig();
	        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	        //WebResource web = Client.create(config).resource(url);
	        WebResource web = Client.create().resource(url);
	        
	        ClientResponse clientResponse = web.accept(MediaType.APPLICATION_JSON)
	                   .get(ClientResponse.class);
			   
			   String json = clientResponse.getEntity(String.class);
		       // JsonResult jsonResult = new JsonResult(clientResponse.getStatus(), json);
		        ObjectMapper mapper = new ObjectMapper();
		        //jsonResult.setMapper(mapper);
	        
		   System.out.println(json);
		    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        return mapper.readValue(json.toString(), mapper.getTypeFactory().constructCollectionType(List.class, PersonBean.class));
		
	}
	public String save(PersonDTO person) throws JsonParseException, JsonMappingException, IOException{
		String baseuri="http://localhost:8060/";
		String url="myproject/api/person/save";
		
		HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter("", "");
         
         
		ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        config.getClasses().add(Provider.class);
	       // resetAuthFilter();
		  WebResource web = Client.create(config).resource(baseuri);
		  web.addFilter(authFilter);
	        ClientResponse clientResponse = web.path(url).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, person);
	        return ""+clientResponse.getStatus();
	        
	        
	        
	    }
		
	}

