package com.example.llubeassignment.dto;

import lombok.Getter;

@Getter
public class ResponseDTO {
    private final String name;
    private final String age;
    private final String gender;

    public ResponseDTO(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
