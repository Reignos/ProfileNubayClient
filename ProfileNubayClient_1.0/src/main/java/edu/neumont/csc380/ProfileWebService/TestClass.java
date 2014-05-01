package edu.neumont.csc380.ProfileWebService;

import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Profile;
import edu.neumont.csc380.ProfileWebService.services.ProfileService;
import edu.neumont.csc380.ProfileWebService.services.ProfileServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		ProfileService test = new ProfileServiceImpl();
		Profile testProf = new Profile();
		ContactInformation ci = new ContactInformation();
		ci.setAddress("123 lane");
		ci.setEmail("yes@yes.yes");
		ci.setPhone("1234567890");
		
		testProf.setFirstName("Robert");
		testProf.setLastName("Mic");
		testProf.setPassword("pass");
		testProf.setUsername("Reign");
		testProf.setContactInformation(ci);
		
		//test.postProfile(testProf);
		
		Profile get = test.getProfile(1);
		System.out.println(get.getFirstName());
		System.out.println(get.getLastName());
		
		get.setFirstName("new name");
		
		test.updateProfile(1, get);
		
		get = test.getProfile(1);
		
		System.out.println(get.getFirstName());
		
		test.deleteProfile(1);
		
		test.getProfile(1);
	}

}
