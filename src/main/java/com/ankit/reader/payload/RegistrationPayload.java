package com.ankit.reader.payload;

import java.util.List;

public class RegistrationPayload {
	
	
	private String email;
	private String firstName;
	private String lastName;
	private String password;	
	
	List<String> roles;
	public RegistrationPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationPayload(String email, String firstName, String lastName, String password
			) {
		super();
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	

}
