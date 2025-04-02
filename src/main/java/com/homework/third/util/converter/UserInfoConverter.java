package com.homework.third.util.converter;

import java.time.Year;

import org.springframework.stereotype.Component;

@Component
public class UserInfoConverter {
	public int getAge(String registrationNumber) {
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

	public String getGender(String registrationNumber) {
		String personalIdPart = registrationNumber.split("-")[1];

		int genderCode = Integer.parseInt(String.valueOf(personalIdPart.charAt(0)));

		if (genderCode % 2 == 0) {
			return "여자";
		} else {
			return "남자";
		}
	}
}