package com.homework.third.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
	@Getter
	@NoArgsConstructor
	public static class UserInfoRequest {
		private String name;
		private String registrationNumber;
	}
}
