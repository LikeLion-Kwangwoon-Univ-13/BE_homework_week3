package com.homework.third.util.validator;

import java.time.Month;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.homework.third.exception.InvalidRegistrationNumberException;
import com.homework.third.exception.message.ExceptionMessage;

@Component
public class RegistrationNumberValidator implements Validator<String> {
	// 주민등록번호 형식에 대한 정규표현식: 정수 6자리, 하이픈(-), 1-4사이의 수, 정수 6자리 형태
	private final String REGISTRATION_NUMBER_REGEX = "^(\\d{6})-(?:[1-4]\\d{6})$";

	@Override
	public boolean isValid(String registrationNumber) {
		// 주민등록번호가 null이거나 정규식 형태와 맞지 않으면 예외 발생
		if (registrationNumber == null || !Pattern.matches(REGISTRATION_NUMBER_REGEX, registrationNumber)) {
			throw new InvalidRegistrationNumberException(ExceptionMessage.INVALID_FORMAT_REGISTRATION_NUMBER);
		}

		// 주민등록번호(생년월일)추출
		String birthDatePart = registrationNumber.split("-")[0];

		// 날짜에 대한 유효선 검증
		if (!isValidDate(birthDatePart)) {
			throw new InvalidRegistrationNumberException(ExceptionMessage.INVALID_DATE_REGISTRATION_NUMBER);
		}

		// 위의 검증 과정을 모두 통과하면 true반환
		return true;
	}

	// 월, 일에 대한 유효성 검증
	private boolean isValidDate(String birthDatePart) {
		int month = Integer.parseInt(birthDatePart.substring(2, 4));
		int day = Integer.parseInt(birthDatePart.substring(4, 6));

		// 1-12월 사이, 1일부터 해당 월의 최대 일수 사이인 경우에만 true반환
		return month >= 1 && month <= 12
			&& day >= 1 && day <= Month.of(month).maxLength();
	}
}