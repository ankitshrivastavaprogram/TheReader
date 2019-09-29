package com.ankit.reader.exception;

public class UsernameNotFoundException extends RuntimeException {
	
	

	private static final long serialVersionUID = 1L;
	private final String message = "Registration Exception username is already exist";
	public UsernameNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getMessage() {
		return message;
	}

}

