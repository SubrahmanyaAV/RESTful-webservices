package com.cruds.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
	
	//localhost:8080/users/1234 - lets say user 1234 does not exist so we want 404
	//thats why we are changing the response status to 404
	//changing 501 to 404 status which is not found 
}

