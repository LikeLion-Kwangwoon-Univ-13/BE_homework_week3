package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final NameValidator nameValidator;
    private final RegistrationNumberValidator registrationNumberValidator;
    private final UserInfoConverter userInfoConverter;

    @Getter //@Setter
    List<User> users = new ArrayList<>();

    public User registerUser(UserRequestDTO userRequestDTO) {
        nameValidator.nameValidator(userRequestDTO);
        registrationNumberValidator.registrationNumberValidator(userRequestDTO);
        User user = userInfoConverter.userInfoCoverter(userRequestDTO);
        users.add(user);
        return user;
    }

}
