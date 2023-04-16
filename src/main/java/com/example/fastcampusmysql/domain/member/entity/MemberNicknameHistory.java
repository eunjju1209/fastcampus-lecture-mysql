package com.example.fastcampusmysql.domain.member.entity;

// 과거의 내역들을 가지고올때 정규화 대상이 아니다
// 정규화 대상이 항상 데이터의 최신성을 보장해야하는가 를 고려해야한다.
// 모호한 케이스 -> 이커머스 -> 주문 내역 제조사 .. 남기는데 (식별자)
// 과거의 데이터를 냅겨야 하는거는 히스토리성 이기때문에 정규화된 데이터가 아니다.

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class MemberNicknameHistory {

    final private Long id;

    final private Long memberId;

    final private String nickname;

    final private LocalDateTime createdAt;

    @Builder
    public MemberNicknameHistory(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}
