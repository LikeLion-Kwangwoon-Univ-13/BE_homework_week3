package com.example.likelion_week3_HW.service;

import com.example.likelion_week3_HW.dto.RequestDto;
import org.springframework.stereotype.Component;

@Component
public class NameValidator {
    public void isValid(RequestDto.UserInfo userInfo) {
        String name = userInfo.getName();
        if(name.length()<=1) {
            throw new IllegalArgumentException("올바른 이름을 입력해주세요.");
        }
    }
}
