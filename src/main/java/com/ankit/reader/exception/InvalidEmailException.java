package com.ankit.reader.exception;

public class InvalidEmailException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "Registration exception email is alredy exists";

	public InvalidEmailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
