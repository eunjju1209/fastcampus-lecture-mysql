package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;

// 레코드 선언 하게 되면 getter, setter 자동으로 만들어주고 getter property 형식으로 가능하다.
// 데이터 리스폰스 객체니까
public record RegisterMemberCommand(
        String email,
        String nickname,
        LocalDate birthday
) {
}
