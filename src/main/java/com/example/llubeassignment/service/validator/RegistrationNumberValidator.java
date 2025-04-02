package com.example.llubeassignment.service.validator;

import org.springframework.stereotype.Component;

@Component
public class RegistrationNumberValidator {
    public boolean validate(String registNum) {
        if (registNum == null || !registNum.contains("-") || registNum.length() != 14) {
            return false;
        }
        String[] parts = registNum.split("-");
        if (parts.length < 2) {
            return false;
        }
        String frontPart = parts[0];
        String backPart = parts[1];

        if (frontPart.length() != 6 || backPart.length() != 7) {
            return false;
        }

        int month = Integer.parseInt(frontPart.substring(2,4));
        int day = Integer.parseInt(frontPart.substring(4,6));
        int[] dayArray = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month < 1 || 12 < month) {
            return false;
        }
        if (dayArray[month-1] < day || day < 1) {
            return false;
        }
        return true;
    }
}
