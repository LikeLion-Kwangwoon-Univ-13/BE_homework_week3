package com.homework.third.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
	// 유저 이름
	private String name;

	// 유저 나이
	private int age;

	// 유저 성별
	private String gender;
}
