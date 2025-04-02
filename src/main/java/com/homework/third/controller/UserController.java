package com.homework.third.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homework.third.dto.UserRequest;
import com.homework.third.dto.UserResponse;
import com.homework.third.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping(path = "/user")
	public ResponseEntity<UserResponse.UserInfoResponse> showUserInfo(
		@RequestBody UserRequest.UserInfoRequest userInfoRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.showUserInfo(userInfoRequest));
	}

	@GetMapping(path = "/user")
	public ResponseEntity<UserResponse.UserInfoList> showUserList() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserList());
	}
}