package com.homework.third.exception.message;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
	INVALID_DATE_REGISTRATION_NUMBER(HttpStatus.BAD_REQUEST, "주민등록번호의 날짜 정보가 올바르지 않습니다."),
	INVALID_FORMAT_REGISTRATION_NUMBER(HttpStatus.BAD_REQUEST, "주민등록번호 형식이 올바르지 않습니다."),
	INVALID_NAME(HttpStatus.BAD_REQUEST, "이름이 올바르지 않습니다.");

	private HttpStatus httpStatus;
	private String message;
}
