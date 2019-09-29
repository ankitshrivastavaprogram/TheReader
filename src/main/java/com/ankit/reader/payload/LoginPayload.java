package com.ankit.reader.payload;

public class LoginPayload {

	private String email;
	private String password;
	public LoginPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginPayload(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
