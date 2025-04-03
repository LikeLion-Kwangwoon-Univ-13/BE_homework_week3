package com.example.first.repository;

import com.example.first.DTO.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryRepository {
    List<User> repository = new ArrayList<>();

    //받은 유저 정보 전체를 반환
    public List<User> getUsers() {
        return repository;
    }

    //유저 정보 저장 기능
    public User saveUser(User user) {
        repository.add(user); //add 기능을 통해 유저 정보를 추가 저장. 원래 요소 뒤에 추가함

        return user;
    }
}
