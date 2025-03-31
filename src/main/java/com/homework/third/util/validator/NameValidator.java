package com.homework.third.util.validator;

import org.springframework.stereotype.Component;

import com.homework.third.exception.InvalidNameException;
import com.homework.third.exception.message.ExceptionMessage;

@Component
public class NameValidator implements Validator<String> {
	@Override
	public boolean isValid(String name) {
		if (name == null || name.isBlank()) {
			throw new InvalidNameException(ExceptionMessage.INVALID_NAME);
		}

		return true;
	}
}