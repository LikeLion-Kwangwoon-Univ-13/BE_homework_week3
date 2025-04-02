package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class NameValidator {
    public void nameValidator(UserRequestDTO userRequestDTO) {
        String name = userRequestDTO.getName();
        if(name.length() <= 1){
            throw new IllegalArgumentException("이름이 1자 이하이거나 공백인 경우");
        }
    }
}
