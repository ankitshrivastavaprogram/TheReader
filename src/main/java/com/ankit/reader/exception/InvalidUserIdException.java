package com.ankit.reader.exception;

public class InvalidUserIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "User id is invalid";

	public InvalidUserIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
