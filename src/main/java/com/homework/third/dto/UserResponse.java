package com.homework.third.dto;

import com.homework.third.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserResponse {
	@Getter
	@AllArgsConstructor
	public static class UserInfoResponse {
		private String name;
		private int age;
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
