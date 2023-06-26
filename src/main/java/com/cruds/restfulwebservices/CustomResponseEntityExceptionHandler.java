package com.cruds.restfulwebservices;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cruds.restfulwebservices.exception.UserNotFoundException;

//applicable to all the controllers for exception handling
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	// can handle any exception using this annotation
	@ExceptionHandler(Exception.class) // copy the structure n rename the method
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		// pre defined ResponseEntityExceptionHandler
		// (ctrl+enter ResponseEntityExceptionHandler ==> scroll down n copy the method)

		//making use of custom exception structure and returning back as the response
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now()
				," Total Errors: " +  ex.getErrorCount() + " ,First Error: " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
