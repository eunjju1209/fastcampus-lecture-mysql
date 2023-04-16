package com.example.fastcampusmysql.domain.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {

    static public Member create() {
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }

    static public Member create(Long seed) {
        // 테스트 객체는 어떻게 생성할까? 라는
        // 값들은 테스트 코드의 케이스 마다 너무 다양해질수도있ㄷㅏ
        // index pattern fixered library
        // EasyRandom

        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
    }
}
