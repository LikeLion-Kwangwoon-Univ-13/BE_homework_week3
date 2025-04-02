package com.homework.third.util.converter;

import java.time.Year;

import org.springframework.stereotype.Component;

import com.homework.third.dto.UserRequest;
import com.homework.third.model.User;
import com.homework.third.util.validator.NameValidator;
import com.homework.third.util.validator.RegistrationNumberValidator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserInfoConverter {
	private final NameValidator nameValidator;
	private final RegistrationNumberValidator registrationNumberValidator;

	public User toEntity(UserRequest.UserInfoRequest userInfoRequest) {
		String name = userInfoRequest.getName();
		String registrationNumber = userInfoRequest.getRegistrationNumber();

		nameValidator.isValid(name);
		registrationNumberValidator.isValid(registrationNumber);

		return new User(name, getAge(registrationNumber), getGender(registrationNumber));
	}

	private int getAge(String registrationNumber) {
		String birthDatePart = registrationNumber.split("-")[0];
		String personalIdPart = registrationNumber.split("-")[1];

		int birthYear = Integer.parseInt(birthDatePart.substring(0, 2));
		int genderCode = Integer.parseInt(String.valueOf(personalIdPart.charAt(0)));

		if (genderCode == 1 || genderCode == 2) {
			birthYear += 1900;
		} else {
			birthYear += 2000;
		}

		return Year.now().getValue() - birthYear;
	}

	private String getGender(String registrationNumber) {
		String personalIdPart = registrationNumber.split("-")[1];

		int genderCode = Integer.parseInt(String.valueOf(personalIdPart.charAt(0)));

		if (genderCode % 2 == 0) {
			return "여자";
		} else {
			return "남자";
		}
	}
}