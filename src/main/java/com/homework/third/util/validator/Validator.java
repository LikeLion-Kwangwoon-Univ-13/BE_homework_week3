package com.homework.third.util.validator;

public interface Validator<T> {
	// 유효성 검증이 발생하는 함수
	boolean isValid(T value);
}
