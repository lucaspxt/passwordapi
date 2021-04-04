package com.lucaspxt.password.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<PasswordResultError> notValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		PasswordResultError err = new PasswordResultError(false);
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			err.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(err);
	}
}
