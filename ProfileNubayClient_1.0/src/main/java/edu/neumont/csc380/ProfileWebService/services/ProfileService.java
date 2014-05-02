package edu.neumont.csc380.ProfileWebService.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.Profile;

@Path("/profile")
@Consumes("application/json")
@Produces("application/json")
public interface ProfileService {
	
	@GET
	@Path("/{id}")
	Response getProfile(@PathParam("id") int id);
	
	@PUT
	@Path("/{id}")
	Response updateProfile(@PathParam("id") int id, Profile profile) throws InvalidInputException;
	
	@POST
	@Path("/create")
	Response postProfile(Profile profile);
	
	@DELETE
	@Path("/{id}")
	Response deleteProfile(@PathParam("id") int id);
	
}
