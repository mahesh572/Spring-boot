package com.mayuktha.userregistration.exception;


public class UserAlreadyExistedException extends RuntimeException{
	public UserAlreadyExistedException(String message) {
		super(message);
	}
}
