package com.ankit.reader.exception;

public class UnAuthorizedActivityCheckerException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "only creater of blog can see the activity";

	public UnAuthorizedActivityCheckerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
