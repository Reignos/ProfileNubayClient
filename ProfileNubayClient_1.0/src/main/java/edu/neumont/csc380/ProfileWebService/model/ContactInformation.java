package edu.neumont.csc380.ProfileWebService.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contactInformation")
public class ContactInformation {
	
	private String phone;
	private String email;
	private String Address;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
}
