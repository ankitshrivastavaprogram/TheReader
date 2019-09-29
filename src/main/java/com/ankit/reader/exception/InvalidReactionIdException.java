package com.ankit.reader.exception;

public class InvalidReactionIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "No blog with this id exists";

	public InvalidReactionIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
