package com.sample.spring_ws_sample.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest request) {
		String str = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError ste = new StandardError(Instant.now(), status.value(), str, error.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ste);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException error, HttpServletRequest request) {
		String str = "Database Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError ste = new StandardError(Instant.now(), status.value(), str, error.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ste);
	}

}
