package edu.neumont.csc380.ProfileWebService.services;

import java.util.Arrays;

import javax.ws.rs.MessageProcessingException;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.Profile;

public class ProfileClient {
	
	private ProfileService service = JAXRSClientFactory.create("http://localhost:8080/ProfileService/rest", ProfileService.class, Arrays.asList(new JacksonJsonProvider()));

	public Profile getProfile(int id){
		return service.getProfile(id).readEntity(Profile.class);
	}
	
	public Profile updateProfile(int id, Profile profile) throws MessageProcessingException, IllegalStateException, InvalidInputException{
		return service.updateProfile(id, profile).readEntity(Profile.class);
	}
	
	public Profile createProfile(Profile profile) throws MessageProcessingException, IllegalStateException, InvalidInputException{
		return service.postProfile(profile).readEntity(Profile.class);
	}
	
	public void deleteProfile(int id){
		service.deleteProfile(id);
	}
	
	public static void main(String[] args) throws MessageProcessingException, IllegalStateException, InvalidInputException{
		ProfileClient p = new ProfileClient();
		Profile prof = p.getProfile(1);
		System.out.println(prof.getFirstName());
		System.out.println(prof.getLastName());
		prof.setFirstName("MyName is Your MOTHER");
		prof.setPassword("1234");
		prof.setUsername("I AM A USER MAYBE");
		prof = p.createProfile(prof);
		System.out.println(prof.getFirstName());
		System.out.println(prof.getLastName());
		p.deleteProfile(3);
	}
}
