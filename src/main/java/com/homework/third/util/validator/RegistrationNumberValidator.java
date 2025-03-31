package com.homework.third.util.validator;

import java.time.Month;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.homework.third.exception.InvalidRegistrationNumberException;
import com.homework.third.exception.message.ExceptionMessage;

@Component
public class RegistrationNumberValidator implements Validator<String> {
	private final String REGISTRATION_NUMBER_REGEX = "^(\\d{6})-(?:[1-4]\\d{6})$";

	@Override
	public boolean isValid(String registrationNumber) {
		if (registrationNumber == null || !Pattern.matches(REGISTRATION_NUMBER_REGEX, registrationNumber)) {
			throw new InvalidRegistrationNumberException(ExceptionMessage.INVALID_FORMAT_REGISTRATION_NUMBER);
		}

		String birthDatePart = registrationNumber.split("-")[0];
		if (!isValidDate(birthDatePart)) {
			throw new InvalidRegistrationNumberException(ExceptionMessage.INVALID_DATE_REGISTRATION_NUMBER);
		}

		return true;
	}

	private boolean isValidDate(String birthDatePart) {
		int month = Integer.parseInt(birthDatePart.substring(2, 4));
		int day = Integer.parseInt(birthDatePart.substring(4, 6));

		return month >= 1 && month <= 12
			&& day >= 1 && day <= Month.of(month).maxLength();
	}
}