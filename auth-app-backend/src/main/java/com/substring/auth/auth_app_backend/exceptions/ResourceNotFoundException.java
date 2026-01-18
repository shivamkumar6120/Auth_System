package com.substring.auth.auth_app_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	public ResourceNotFoundException() {
		super("Resource not found !!");
	}
	
}
