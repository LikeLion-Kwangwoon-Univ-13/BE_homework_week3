package com.homework.third.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.homework.third.dto.UserRequest;
import com.homework.third.dto.UserResponse;
import com.homework.third.model.User;
import com.homework.third.util.converter.UserInfoConverter;
import com.homework.third.util.validator.NameValidator;
import com.homework.third.util.validator.RegistrationNumberValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final NameValidator nameValidator;
	private final RegistrationNumberValidator registrationNumberValidator;
	private final UserInfoConverter userInfoConverter;

	List<User> users = new ArrayList<>();

	public UserResponse.UserInfoResponse showUserInfo(UserRequest.UserInfoRequest userInfoRequest) {
		//converter를 dto내에서 호출하도록 변경하여 캡슐화원칙 지키도록 변경하기
		String name = userInfoRequest.getName();
		String registrationNumber = userInfoRequest.getRegistrationNumber();

		nameValidator.isValid(name);
		registrationNumberValidator.isValid(registrationNumber);

		User user = new User(name, userInfoConverter.getAge(registrationNumber),
			userInfoConverter.getGender(registrationNumber));

		users.add(user);

		return UserResponse.UserInfoResponse.of(user);
	}

	public List<UserResponse.UserInfoResponse> getUserList() {
		return this.users.stream()
			.map(UserResponse.UserInfoResponse::of)
			.collect(Collectors.toList());
	}
}