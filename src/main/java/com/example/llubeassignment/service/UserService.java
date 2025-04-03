package com.example.llubeassignment.service;

import com.example.llubeassignment.dto.RegistrationFormDTO;
import com.example.llubeassignment.dto.ResponseDTO;
import com.example.llubeassignment.entity.User;
import com.example.llubeassignment.service.converter.UserInfoConverter;
import com.example.llubeassignment.service.validator.NameValidator;
import com.example.llubeassignment.service.validator.RegistrationNumberValidator;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NameValidator nameValidator;
    private final RegistrationNumberValidator registrationNumberValidator;
    private final UserInfoConverter userInfoConverter;

    private final List<User> users = new ArrayList<>();

    public List<ResponseDTO> getAllUsers() {
        List<ResponseDTO> resDTOArray = new ArrayList<>();
        for (User user : users) {
            resDTOArray.add(new ResponseDTO(user.getName(), user.getAge(), user.getGender()));
        }
        return resDTOArray;
    }

    public ResponseDTO register(RegistrationFormDTO userReq) {

        if (!nameValidator.validate(userReq.getName())) {
            throw new IllegalArgumentException("올바른 이름을 입력해주세요.");
        }
        if (!registrationNumberValidator.validate(userReq.getRegistrationNumber())) {
            throw new IllegalArgumentException("올바른 주민등록번호를 입력해주세요.");
        }

        User convertedUser = userInfoConverter.convert(userReq);
        users.add(convertedUser);

        return new ResponseDTO(convertedUser.getName(), convertedUser.getAge(), convertedUser.getGender());
    }
}
