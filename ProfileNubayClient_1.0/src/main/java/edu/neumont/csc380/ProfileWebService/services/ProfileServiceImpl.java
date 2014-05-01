package edu.neumont.csc380.ProfileWebService.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.neumont.csc380.ProfileWebService.model.Profile;

public class ProfileServiceImpl implements ProfileService{
	
	private static final String url = "http://localhost:8080";
	
	public ProfileServiceImpl(){
	}

	public Profile getProfile(int id) {
		Client client = ClientBuilder.newBuilder().newClient();
		WebTarget target = client.target(url).path(id + "");
		Response response = target.request().get();
		if(response.getStatus() == 200)
			return (Profile) response.getEntity();
		else
			return null;
	}

	public Response updateProfile(int id, Profile profile) {
		Client client = ClientBuilder.newBuilder().newClient();
		WebTarget target = client.target(url).path(id + "");
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
					.put(Entity.entity(profile, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		return response;
	}

	public Response postProfile(Profile profile) {
		Client client = ClientBuilder.newBuilder().newClient();
		WebTarget target = client.target(url);
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(profile, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		return response;
	}

	public Response deleteProfile(int id) {
		Client client = ClientBuilder.newBuilder().newClient();
		WebTarget target = client.target(url).path(id + "");
		Response response = target.request().delete();
		return response;
	}
}
