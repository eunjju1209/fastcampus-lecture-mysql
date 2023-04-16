package com.example.fastcampusmysql.util;

import java.util.List;

// 여러객체 페이징 인터페이스 처럼 받아야 하니까 제네릭으로 명시
public record PageCursor<T> (
    CursorRequest nextCursorRequest,
    List<T> body
) {
}
