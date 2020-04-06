package com.imcs.employeeServiceApp.exceptions;

public class BadDataException extends RuntimeException {

	public BadDataException() {
		
	}

	public BadDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BadDataException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BadDataException(String message) {
		super(message);
		
	}

	public BadDataException(Throwable cause) {
		super(cause);
		
	}
	
	

}
