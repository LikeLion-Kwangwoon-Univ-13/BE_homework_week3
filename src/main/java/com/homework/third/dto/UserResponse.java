package com.homework.third.dto;

import com.homework.third.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserResponse {
	@Getter
	@AllArgsConstructor
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
}
