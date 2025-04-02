package com.example.llubeassignment.dto;

import lombok.Getter;

@Getter
public class RegistrationFormDTO {
    private final String name;
    private final String registrationNumber;

    public RegistrationFormDTO(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }
}
