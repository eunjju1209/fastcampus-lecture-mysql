package com.example.fastcampusmysql.domain.post.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Post {

    // 이미지 업로드 , 동영상 업로드, 게시물 수정, 댓글

    final private Long id;

    final private Long memberId;

    final private String contents;

    final private LocalDate createdDate;

    private Long likeCount;

    // 모든 update 쿼리에서는 version 이 올라가야한다.
    private Long version;

    final private  LocalDateTime createdAt;


    @Builder
    public Post(Long id, Long memberId, String contents, LocalDate createdDate, Long likeCount, Long version, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.contents = Objects.requireNonNull(contents);
        this.createdDate = createdDate == null ? LocalDate.now() : createdDate;
        // 데이터 사이즈가 10만개인 경우에 default 를 넣은 필드를 만들어 줄 경우 테이블 락이 생길 가능성이높다
        // 그래서 별도의 마이그레이션 배치를 만들어서 조금씩 데이터 채워넣는 전략 또는 조회시점에 null 이면 값을 채워주는 역할을 만들어주는
        this.likeCount = likeCount == null ? 0 : likeCount;
        this.version = version == null ? 0 : version;
        this.createdAt = createdAt == null? LocalDateTime.now() : createdAt;
    }

    public void incrementLikecount() {
        likeCount += 1;
    }
}
