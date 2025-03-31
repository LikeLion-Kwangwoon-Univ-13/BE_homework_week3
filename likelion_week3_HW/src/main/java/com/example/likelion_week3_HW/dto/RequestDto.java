package com.example.likelion_week3_HW.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class RequestDto {

    @Getter
    @AllArgsConstructor
    public static class UserInfo {
        private String name;
        private String registrationNumber;
    }
}
