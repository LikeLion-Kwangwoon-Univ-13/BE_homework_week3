package com.homework.third.exception;

import org.springframework.http.HttpStatus;

import com.homework.third.exception.message.ExceptionMessage;

import lombok.Getter;

@Getter
public class InvalidRegistrationNumberException extends RuntimeException {
	private HttpStatus status;
	private String message;

	public InvalidRegistrationNumberException(ExceptionMessage exceptionMessage) {
		this.status = exceptionMessage.getHttpStatus();
		this.message = exceptionMessage.getMessage();
	}
}
