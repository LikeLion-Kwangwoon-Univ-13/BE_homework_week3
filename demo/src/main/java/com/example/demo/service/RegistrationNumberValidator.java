package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class RegistrationNumberValidator {
    public void registrationNumberValidator(UserRequestDTO userRequestDTO) {
        String registrationNumber = userRequestDTO.getRegistrationNumber();

        String[] parts = registrationNumber.split("-");

        int genderInfo = parts[1].charAt(0) - 48;
        if(genderInfo < 1 || genderInfo > 4) {
            throw new IllegalArgumentException("뒷자리의 가장 첫 숫자가 1,2,3,4 이외의 수인 경우");
        }

        int month = Integer.parseInt(parts[0].substring(2, 4));
        int day = Integer.parseInt(parts[0].substring(4, 6));

        if(month < 1 || month > 12){
            throw new IllegalArgumentException("앞자리의 월에 해당하는 수가 1~12 이외의 수인 경우 ");
        }

        int[] dayValidation = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(day < 1 || day > dayValidation[month - 1]){
            throw new IllegalArgumentException("앞자리의 마지막 두 자리 수가 해당 월의 일수를 벗어나는 경우");
        }
    }
}
