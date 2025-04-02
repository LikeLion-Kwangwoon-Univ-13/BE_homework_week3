package com.example.llubeassignment.service.converter;

import com.example.llubeassignment.dto.RegistrationFormDTO;
import com.example.llubeassignment.entity.User;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class UserInfoConverter {
    public User convert(RegistrationFormDTO userInfo) {
        int birthYear = Integer.parseInt(userInfo.getRegistrationNumber().substring(0,2));
        int genderNum = Integer.parseInt(userInfo.getRegistrationNumber().substring(7,8));
        String gender = "남자"; //9, 1, 3, 5, 7
        if (genderNum % 2 == 0) {
            gender = "여자"; // 0, 2, 4, 6, 8
            genderNum--; // 남자랑 동일하게 맞추기!
        }

        switch (genderNum) {
            case 9:
                birthYear = birthYear + 1800;
                break;
            case 1:
                birthYear = birthYear + 1900;
                break;
            case 3:
                birthYear = birthYear + 2000;
                break;
            case 5:
                birthYear = birthYear + 1900;
                break;
            case 7:
                birthYear = birthYear + 2000;
                break;
        }

        int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear; //연나이

        return new User(userInfo.getName(), Integer.toString(age), gender);
    }
}
