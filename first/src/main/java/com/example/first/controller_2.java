package com.example.first;
import java.util.ArrayList;
import java.util.List; //동적임

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;


//조회, 검색(GET), 생성(POST), 덮어쓰기(PUT), 부분 수정(PATCH), 삭제(DELETE)
//@RestController("/api")
public class controller_2 {

    private List<MemberDTO> users = new ArrayList<>();

    @GetMapping("/get") //이 어노테이션은 보통 클래스 안/밖에 쓰여서 메소드를 꼭 만들어줘야함
    //get 요청은 로그인기능이나 뭐 이런거 있지 않는 이상 요청에는 content - type이 없음.
    //그냥 sring만 받을 때는 text/plain 으로 쓰기. json XX
    public ResponseEntity<?> get(){

        if(users.isEmpty()) {//메소드
            //ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request", "비어있음", LocalDateTime.now()) //세번쨰가 사용자한테 보여주는 부분
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not users Found");
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/post")
    public String post(@RequestBody MemberDTO member){ //회색글씨 변수 이름
        users.add(member); //요청이랑 이미 있는게 똑같으면 그냥 바로 저장으로 넣어줌.
        //만약 나한테는 Name 이라고 저장되어 있는데 요청이 name이면 바로 저장 안 됨. 오류 발생. 다른 거 똑같으면 이름만 NUll로 뜨고 나머지는 그대로 계속 진행됨.
        return "저장완료.";
    }

    @PutMapping("/put")
    public String put(){
        return "put 요청이 들어옴.";
    }

    @PatchMapping("/patch")
    public String patch(){
        return "patch 요청이 들어옴.";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "delete 요청이 들어옴.";
    }

}
