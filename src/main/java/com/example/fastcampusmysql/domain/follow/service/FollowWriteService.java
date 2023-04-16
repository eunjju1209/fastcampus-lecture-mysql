package com.example.fastcampusmysql.domain.follow.service;


import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class FollowWriteService {

    final private FollowRepository followRepository;

    /**
     * public void create(Long fromMemberId, Long toMemberId) {    // 식별자로 받는다
     * 이렇게 되면 member.id 를 하기 위해서는 결합도가 강해지기 떄문에 Member.id 결합도를 최대한 낮추기 위해서는 DTO 로 전달 받는다.
     * 서로 다른 도메인들을 흐름 제어하거 데이터를 주고받을 때 어디서 해야하는가
     * 방법론 -> DDD, 헥사고날 아키텍쳐, 레이어드 아키텍쳐 (경계를 나누고 경계간의 데이터를 나눌때)
     * @param fromMember
     * @param toMember
     */
//

    public void create(MemberDto fromMember, MemberDto toMember) {
        /**
         * from, to 회원 정보를 받아서 저장
         * from <-> to validate
         */

        Assert.isTrue(!fromMember.id().equals(toMember.id()), "From To 회원이 동일합니다.");

        Follow follow = Follow.builder()
                .fromMemberId(fromMember.id())
                .toMemberId(toMember.id())
                .build();

        followRepository.save(follow);
    }
}
