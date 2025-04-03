package com.example.first.DTO;

import lombok.Data;

@Data //get.set 기능 다 해줌
public class User {
    private String name; //String 자체를 class로 봐서 대문자임.
    private String id;
    //private String age;
    private String gender;

    public User(String name, String id) {
        this.name = name; //생성자
        this.id = id;
        //this.age = age;
    }
}
