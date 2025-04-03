package com.example.first.service;
import com.example.first.DTO.User;
import com.example.first.repository.MemoryRepository;
import com.example.first.validation.RRNValidator;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    //final 상수. 대신 값이 무조건 있어야 함.
    private final MemoryRepository memoryRepository;
    private final RRNValidator rrnValidator;

    //데이터 베이스가 필요하니까 받아옴.
    Service(MemoryRepository memoryRepository, RRNValidator rrnValidator) {
        this.memoryRepository = memoryRepository;
        this.rrnValidator = rrnValidator;
    }

    public List<User> getUsers(){
        List<User> users = memoryRepository.getUsers();

        return users;
    }

    public User saveUser(User user){
        //검증
        User user_validated = rrnValidator.validateRRN(user.getName(), user.getId());
        //검증 후에 재저장
        return memoryRepository.saveUser(user_validated); //saveUser로 레포지토리에 다시 자장
    }
}
