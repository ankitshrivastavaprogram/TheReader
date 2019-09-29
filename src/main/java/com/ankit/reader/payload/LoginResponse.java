package com.ankit.reader.payload;

public class LoginResponse {
	
	private String Bearer;
	private boolean status;
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginResponse(String Bearer, boolean status) {
		super();
		this.Bearer = Bearer;
		this.status = status;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBearer() {
		return Bearer;
	}
	public void setBearer(String bearer) {
		Bearer = bearer;
	}
	
	
	
	

}
