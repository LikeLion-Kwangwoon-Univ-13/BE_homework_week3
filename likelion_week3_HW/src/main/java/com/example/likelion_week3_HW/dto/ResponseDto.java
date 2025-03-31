package com.example.likelion_week3_HW.dto;

import com.example.likelion_week3_HW.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {

    @Getter
    @NoArgsConstructor
    public static class UserInfo{
        private String name;
        private int age;
        private String gender;

        public UserInfo(User user) {
            this.name = user.getName();
            this.age = user.getAge();
            this.gender = user.getGender();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class UserList{
        private List<User> users;
    }

    @Getter
    @AllArgsConstructor
    public static class Error{
        private String message;
    }

    @Getter
    @AllArgsConstructor
    public static class Message{
        private String message;
    }
}
