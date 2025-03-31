package com.example.likelion_week3_HW.controller;

import com.example.likelion_week3_HW.dto.RequestDto;
import com.example.likelion_week3_HW.dto.ResponseDto;
import com.example.likelion_week3_HW.entity.User;
import com.example.likelion_week3_HW.service.UserService;
import lombok.RequiredArgsConstructor;
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
            return ResponseEntity.badRequest().body(new ResponseDto.Error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok().body(new ResponseDto.UserList(users));
    }
}
