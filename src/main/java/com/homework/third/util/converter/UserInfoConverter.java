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

		// 입력받은 정보를 모델로 변환하기 전에 검증
		nameValidator.isValid(name);	// 이름 유효성 검증
		registrationNumberValidator.isValid(registrationNumber);	// 주민등록번호 유효성 검증

		// 유저 모델 생성 후 반환
		return new User(name, getAge(registrationNumber), getGender(registrationNumber));
	}

	private int getAge(String registrationNumber) {
		// 주민등록번호 앞자리(생년월일) 추출
		String birthDatePart = registrationNumber.split("-")[0];

		// 주민등록번호 뒷자리 추출
		String personalIdPart = registrationNumber.split("-")[1];

		// 태어난 연도 추출
		int birthYear = Integer.parseInt(birthDatePart.substring(0, 2));

		// 성별에 대한 번호 추출
		int genderCode = Integer.parseInt(String.valueOf(personalIdPart.charAt(0)));

		// 주민등록번호 뒷자리를 이용하여 태어난 연도 결정
		if (genderCode == 1 || genderCode == 2) {
			birthYear += 1900;
		} else {
			birthYear += 2000;
		}

		// '현재 년도 - 태어난 연도'를 통해 나이 계산
		return Year.now().getValue() - birthYear;
	}

	private String getGender(String registrationNumber) {
		// 주민등록번호 뒷자리 추출
		String personalIdPart = registrationNumber.split("-")[1];

		// 성별에 대한 번호 추출
		int genderCode = Integer.parseInt(String.valueOf(personalIdPart.charAt(0)));

		// 성별 결정
		if (genderCode % 2 == 0) {
			return "여자";
		} else {
			return "남자";
		}
	}
}