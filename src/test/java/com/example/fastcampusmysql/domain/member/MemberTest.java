package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    // 테스트 코드
    // 테스트 코드를 짤때는 if 문 또는 거의 분기 위주로 작성해주는게 좋다.

    /**

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
        // easy random -> seed 기반으로 ..
        LongStream.range(0, 10)
                .mapToObj(MemberFixtureFactory::create)
                .forEach(member -> {
                    System.out.println(member.getNickname());
                });
    }
     *
 */

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
        var member = MemberFixtureFactory.create();
        var expected = "pnu";

        member.changeNickname(expected);
        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void  testNicknameMaxLength() {
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnupnupnupnu";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            member.changeNickname(overMaxLengthName);
        });
    }
}
