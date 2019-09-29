package com.ankit.reader.exception;

public class BlogAlreadyExsitsException extends RuntimeException {
	
	

	private static final long serialVersionUID = 1L;
	private final String message = "Blog with this title is already exist";
	public BlogAlreadyExsitsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getMessage() {
		return message;
	}

}
