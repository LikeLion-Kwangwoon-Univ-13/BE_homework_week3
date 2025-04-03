package com.example.first;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 롬복 기능 중 하나로 생성자를 만들어줌
@Data //setter/getter를 만들어줌.

public class MemberDTO {
    private String username;
    private String userpart;
}

