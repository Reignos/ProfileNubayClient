package edu.neumont.csc380.ProfileWebService.services;

import java.util.Arrays;

import javax.ws.rs.MessageProcessingException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.Profile;

public class ProfileClient {
	
	private ProfileService service = JAXRSClientFactory.create("http://localhost:7075/ProfileService/rest", ProfileService.class, Arrays.asList(new JacksonJsonProvider()));

	public Profile getProfile(int id){
		Response response = service.getProfile(id);
		Profile gotProfile = null;
		if(response.getStatus() == 200){
			gotProfile = response.readEntity(Profile.class);
		}
		return gotProfile;
	}
	
	public Profile updateProfile(int id, Profile profile) throws MessageProcessingException, IllegalStateException, InvalidInputException{
		return service.updateProfile(id, profile).readEntity(Profile.class);
	}
	
	public Profile createProfile(Profile profile) throws MessageProcessingException, IllegalStateException, InvalidInputException{
		return service.postProfile(profile).readEntity(Profile.class);
	}
	
	public void deleteProfile(int id){
		Response response = service.deleteProfile(id);
	}
}
