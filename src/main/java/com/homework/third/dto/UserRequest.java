package com.homework.third.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
	@Getter
	@NoArgsConstructor
	public static class UserInfoRequest {
		// 유저 이름
		private String name;

		// 유저 주민등록번호
		private String registrationNumber;
	}
}
