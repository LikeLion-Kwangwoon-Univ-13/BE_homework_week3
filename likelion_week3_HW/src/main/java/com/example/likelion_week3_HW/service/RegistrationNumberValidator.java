package com.example.likelion_week3_HW.service;

import com.example.likelion_week3_HW.dto.RequestDto;
import org.springframework.stereotype.Component;

@Component
public class RegistrationNumberValidator {
    public void isValid(RequestDto.UserInfo userInfo) {

        String registrationNumber = userInfo.getRegistrationNumber();

        if (registrationNumber == null || !registrationNumber.contains("-")) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        String[] parts = registrationNumber.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        String front = parts[0].trim();
        String back = parts[1].trim();

        if (front.length() != 6 || back.length() != 7) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        char genderCode = back.charAt(0);
        if (genderCode < '1' || genderCode > '4') {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        int month = Integer.parseInt(front.substring(2, 4));
        int day = Integer.parseInt(front.substring(4, 6));

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (day < 1 || day > daysInMonth[month - 1]) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }
    }
}
