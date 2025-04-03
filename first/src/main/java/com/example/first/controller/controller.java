package com.example.first.controller;

import com.example.first.DTO.User;
import com.example.first.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//유저 저장에는 유저 정보가 들어오면 서비스로 저장을 부탁함.
@RestController()
@RequestMapping("api")
public class controller {

    private final Service service;

    // 의존성
    controller(Service service) {
        this.service = service;
    }

    //유저 정보 -> 서비스
    @GetMapping("/get")
    public List<User> getUsers() {
        return service.getUsers(); //내가 입력한 모든 정보를 반환함.
    }

    //전체 유저 조회
    @PostMapping("/post")
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

}
