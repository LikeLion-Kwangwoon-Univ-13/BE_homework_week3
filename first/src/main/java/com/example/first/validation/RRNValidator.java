package com.example.first.validation;

import com.example.first.DTO.User;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;

@Component //bean으로 등록하기 위해서 이 어노테이션을 씀.
public class RRNValidator {

    public User validateRRN(String name, String rrn) {

        String yy = rrn.substring(0, 2);
        String mm = rrn.substring(2, 4);
        String dd = rrn.substring(4, 6);
        char gender = rrn.charAt(7);

        int baseYear = (gender == '1' || gender == '2') ? 1900 : 2000;

        int birthYear = baseYear + Integer.parseInt(yy);
        int birthMonth = Integer.parseInt(mm);
        int birthDay = Integer.parseInt(dd);

        LocalDate birthDate;
        try {
            birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("생년월일이 유효X!!!!", e);
        }

        if(birthDay > 30 || birthDay < 1) {
            throw new IllegalArgumentException("유효하지 않은 일수");
        }

        if(name.length() <= 1){
            throw new IllegalArgumentException("유효하지 않은 이름");
        }


        User user = new User(name, rrn);

        if (gender == '1' || gender == '3') {
            user.setGender("남성");
        } else if (gender == '2' || gender == '4') {
            user.setGender("여성");
        } else {
            throw new IllegalArgumentException("유효하지 않은 성별이요");
        }

        return user;

    }

}
