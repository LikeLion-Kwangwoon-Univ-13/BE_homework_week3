package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private int age;
    private String gender;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.gender = user.getGender();
    }
}
