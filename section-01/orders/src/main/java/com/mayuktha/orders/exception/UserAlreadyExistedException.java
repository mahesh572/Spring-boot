package com.mayuktha.orders.exception;


public class UserAlreadyExistedException extends RuntimeException{
	public UserAlreadyExistedException(String message) {
		super(message);
	}
}
