package edu.neumont.csc380.ProfileWebService.services;

import javax.ws.rs.core.Response;

import edu.neumont.csc380.ProfileWebService.model.Profile;

public interface ProfileService {

	public Profile getProfile(int id);
	
	public Response updateProfile(int id, Profile profile);
	
	public Response postProfile(Profile profile);
	
	public Response deleteProfile(int id);
}
