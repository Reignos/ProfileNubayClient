package edu.neumont.csc380.ProfileWebService;

import javax.ws.rs.MessageProcessingException;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.Profile;
import edu.neumont.csc380.ProfileWebService.services.ProfileClient;

public class Driver {

	public static void main(String args[]){
		ProfileClient p = new ProfileClient();
		Profile prof = p.getProfile(1);
		System.out.println(prof.getFirstName());
		System.out.println(prof.getLastName());
		prof.setFirstName("first name change");
		try {
			prof = p.updateProfile(1, prof);
			System.out.println("first name changed to " + prof.getFirstName());
		} catch (Exception e) {
			System.out.println("user not authorized");
		} 
		prof.setFirstName("different user first name");
		prof.setLastName("different user last name");
		prof.setUsername("different");
		prof.setPassword("password");
		try {
			prof = p.createProfile(prof);
			System.out.println("create user " + prof.getFirstName());
			System.out.println(prof.getLastName());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.deleteProfile(1);
	}
}
