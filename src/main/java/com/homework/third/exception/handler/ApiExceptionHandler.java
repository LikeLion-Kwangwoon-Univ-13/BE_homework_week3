package com.homework.third.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.homework.third.exception.InvalidNameException;
import com.homework.third.exception.InvalidRegistrationNumberException;

@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(InvalidRegistrationNumberException.class)
	public ResponseEntity<String> handleInvalidRegistrationNumberException(InvalidRegistrationNumberException e) {
		return ResponseEntity.status(e.getStatus()).body(e.getMessage());
	}

	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<String> handleInvalidNameException(InvalidNameException e) {
		return ResponseEntity.status(e.getStatus()).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}
