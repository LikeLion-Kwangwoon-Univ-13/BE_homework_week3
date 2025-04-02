package com.homework.third.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.homework.third.model.User;

import lombok.Getter;

public class UserResponse {
	@Getter
	public static class UserInfoResponse {
		// 유저 이름
		private String name;

		// 유저 나이
		private int age;

		// 유저 성별
		private String gender;

		public UserInfoResponse(User user) {
			this.name = user.getName();
			this.age = user.getAge();
			this.gender = user.getGender();
		}

		public static UserInfoResponse of(User user) {
			return new UserInfoResponse(user);
		}
	}

	@Getter
	public  static class UserInfoList{
		// 유저 정보 리스트
		private List<UserInfoResponse> userList;

		public UserInfoList(List<User> users){
			this.userList = users.stream()
				.map(UserResponse.UserInfoResponse::of)
				.collect(Collectors.toList());
		}

		public static UserInfoList of(List<User> users){
			return new UserInfoList(users);
		}
	}
}
