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
	private final UserInfoConverter userInfoConverter;

	private List<User> users = new ArrayList<>();

	public UserResponse.UserInfoResponse showUserInfo(UserRequest.UserInfoRequest userInfoRequest) {
		User user = userInfoConverter.toEntity(userInfoRequest);
		users.add(user);

		return UserResponse.UserInfoResponse.of(user);
	}

	public List<UserResponse.UserInfoResponse> getUserList() {
		return this.users.stream()
			.map(UserResponse.UserInfoResponse::of)
			.collect(Collectors.toList());
	}
}