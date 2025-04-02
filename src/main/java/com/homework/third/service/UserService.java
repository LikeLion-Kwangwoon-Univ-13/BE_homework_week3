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

	// 유저 모델 관리를 위한 리스트
	private List<User> users = new ArrayList<>();

	// 입력받은 정보를 모델 스키마에 맞게 변경 후 반환
	public UserResponse.UserInfoResponse showUserInfo(UserRequest.UserInfoRequest userInfoRequest) {
		// 입력받은 데이터를 유저 정보로 반환
		User user = userInfoConverter.toEntity(userInfoRequest);

		// 유저 리스트에 유저 정보 저장
		users.add(user);

		return UserResponse.UserInfoResponse.of(user);
	}

	public List<UserResponse.UserInfoResponse> getUserList() {
		// 유저 리스트의 유저들을 응답 형태로 변환하여 반환
		return this.users.stream()
			.map(UserResponse.UserInfoResponse::of)
			.collect(Collectors.toList());
	}
}