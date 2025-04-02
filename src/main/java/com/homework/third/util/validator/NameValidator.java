package com.homework.third.util.validator;

import org.springframework.stereotype.Component;

import com.homework.third.exception.InvalidNameException;
import com.homework.third.exception.message.ExceptionMessage;

@Component
public class NameValidator implements Validator<String> {
	@Override
	public boolean isValid(String name) {
		// 입력받은 이름이 null이거나 공백만 존재하는 문자열인 경우 예외 발생
		if (name == null || name.isBlank()) {
			throw new InvalidNameException(ExceptionMessage.INVALID_NAME);
		}

		// 위의 검증 과정을 모두 통과하면 true반환
		return true;
	}
}