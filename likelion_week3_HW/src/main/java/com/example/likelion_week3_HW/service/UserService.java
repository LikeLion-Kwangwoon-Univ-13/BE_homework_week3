package com.example.likelion_week3_HW.service;

import com.example.likelion_week3_HW.dto.RequestDto;
import com.example.likelion_week3_HW.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final NameValidator nameValidator;
    private final RegistrationNumberValidator registrationNumberValidator;
    private final UserInfoConverter userInfoConverter;

    @Getter
    private List<User> users = new ArrayList<>();

    public User register(RequestDto.UserInfo userInfo) {
        nameValidator.isValid(userInfo);
        registrationNumberValidator.isValid(userInfo);
        User user = userInfoConverter.convert(userInfo);
        users.add(user);
        return user;
    }

}
