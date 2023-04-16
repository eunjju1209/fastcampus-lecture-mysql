package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {

    // 식별 할 수 있는
    final private Long id;

    private String nickname;            // 닉네임을 변경 ? 하기 위해서 final 안함    객체의 데이터는 데이터 안에서만 관리해야하는걸 선호한다 그래야 나중에 사이드 이펙트가 관리하기 쉬움

    final private String email;

    final private LocalDate birthday;

    // 생성할 때 엔티티 모두다 다넣어준다

    final private LocalDateTime createdAt;

    final private static Long NAME_MAX_LENGTH = 10L;

    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);

        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void changeNickname(String to) {
        // 빈값인지 체크
        Objects.requireNonNull(to);
        // 10개 글자 체크하는 것
        validateNickname(to);
        nickname = to;
    }

    // 닉네임 체킹하는 함수
    private void validateNickname(String nickname) {
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초대했습니다.");
    }
}
