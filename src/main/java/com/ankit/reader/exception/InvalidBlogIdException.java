package com.ankit.reader.exception;

public class InvalidBlogIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "No reaction with this id exists";

	public InvalidBlogIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
