package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserInfoConverter {
    public User userInfoCoverter(UserRequestDTO userRequestDTO) {
        String name = userRequestDTO.getName();
        int age;
        String gender = "";

        String registrationNumber = userRequestDTO.getRegistrationNumber();
        String[] parts = registrationNumber.split("-");

        int genderInfo = parts[1].charAt(0) - 48;
        int userYear = Integer.parseInt(parts[0].substring(0, 2));
        int currentYear = LocalDate.now().getYear();

        if(genderInfo == 1) {
            gender = "남자";
            userYear += 1900;
        }
        else if(genderInfo == 2) {
            gender = "여자";
            userYear += 1900;
        }
        else if(genderInfo == 3) {
            gender = "남자";
            userYear += 2000;
        }
        else if(genderInfo == 4) {
            gender = "여자";
            userYear += 2000;
        }

        age = currentYear - userYear;

        return new User(name, age, gender);
    }
}
