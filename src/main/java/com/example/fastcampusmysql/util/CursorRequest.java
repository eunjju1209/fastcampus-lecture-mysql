package com.example.fastcampusmysql.util;

// cursor key 사용할때 식별자.. 중복키 발생 안하는걸로..
// 인덱스가 있어야 하고, 중복될 가능성이 전혀 없어야한다.
public record CursorRequest(Long key, int size) {

    public static final Long NONE_KEY = -1L;

    // 여기서 체크하는 이유는 key를 갖고있는지 안갖고있는지 정책이 바뀔수가 있다.
    //
    public Boolean hasKey() {
        return key != null;
    }

    // 상수로 빼는 이유는 키만 바뀌고 사이즈 동일
    public CursorRequest next(Long key) {
        return new CursorRequest(key, size);
    }


}
