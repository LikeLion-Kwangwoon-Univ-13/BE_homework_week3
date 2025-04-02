package com.example.llubeassignment.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private final String age;
    private final String gender;

    public User(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
