package com.example.likelion_week3_HW.controller;

import com.example.likelion_week3_HW.dto.RequestDto;
import com.example.likelion_week3_HW.dto.ResponseDto;
import com.example.likelion_week3_HW.entity.User;
import com.example.likelion_week3_HW.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody RequestDto.UserInfo userInfo) {
        try {
            User user = userService.register(userInfo);
            return ResponseEntity.ok().body(new ResponseDto.UserInfo(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto.Error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        List<User> users = userService.getUsers();
        if(!users.isEmpty())
            return ResponseEntity.ok().body(new ResponseDto.UserList(users));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto.Error("유저가 존재하지 않습니다."));
    }
}
