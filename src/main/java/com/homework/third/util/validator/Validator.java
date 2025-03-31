package com.homework.third.util.validator;

public interface Validator<T> {
	boolean isValid(T value);
}
