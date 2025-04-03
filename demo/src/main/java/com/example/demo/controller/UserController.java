package com.example.demo.controller;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUser(
            @RequestBody UserRequestDTO userRequestDTO
    ){
        try{
            User user = userService.registerUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
