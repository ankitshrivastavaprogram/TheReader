package com.ankit.reader.exception;

public class UsernameAlreadyExsitsException extends RuntimeException {
	
	

	private static final long serialVersionUID = 1L;
	private final String message = "Registration Exception username is already exist";
	public UsernameAlreadyExsitsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getMessage() {
		return message;
	}

}
