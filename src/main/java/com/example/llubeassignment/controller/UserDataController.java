package com.example.llubeassignment.controller;

import com.example.llubeassignment.dto.RegistrationFormDTO;
import com.example.llubeassignment.entity.User;
import com.example.llubeassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserDataController {

    private final UserService userService;

    public UserDataController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registrateUser(@RequestBody RegistrationFormDTO requestData) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.register(requestData));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }
}
