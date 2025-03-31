package com.example.likelion_week3_HW.service;

import com.example.likelion_week3_HW.dto.RequestDto;
import com.example.likelion_week3_HW.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

@Component
public class UserInfoConverter {
    public User convert(RequestDto.UserInfo userInfo) {
        String name;
        int age;
        String gender="";

        name = userInfo.getName();

        String[] parts = userInfo.getRegistrationNumber().split("-");
        int genderCode = parts[1].trim().charAt(0) - 48;
        String yearCode = parts[0].trim().substring(0,2);
        int nowYear = LocalDate.now().getYear();
        String bornYear = "";

        if(genderCode == 1) {
            gender = "남자";
            bornYear = "19"+yearCode;
        }
        else if(genderCode == 2) {
            gender = "여자";
            bornYear = "19"+yearCode;
        }
        else if(genderCode == 3) {
            gender = "남자";
            bornYear = "20"+yearCode;
        }
        else if(genderCode == 4) {
            gender = "여자";
            bornYear = "20"+yearCode;
        }

        age = nowYear - parseInt(bornYear) + 1;

        return new User(name,age,gender);
    }
}
