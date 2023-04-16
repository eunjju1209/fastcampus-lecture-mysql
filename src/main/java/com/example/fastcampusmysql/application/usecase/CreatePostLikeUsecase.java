package com.example.fastcampusmysql.application.usecase;

import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import com.example.fastcampusmysql.domain.post.service.PostLikeWriteService;
import com.example.fastcampusmysql.domain.post.service.PostReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostLikeUsecase {

    final private PostReadService postReadService;
    final private MemberReadService memberReadService;
    final private PostLikeWriteService postLikeWriteService;


    // 코드작업은 더 들어갔지만 write 성능 더 좋아진다. postId -> 락을 안잡아도 된다. 인서트이기때문에
    // 하나의 자원에 대해서 서로 update 치려고 경합하지 않는데
    // insert 만 하니까
    // 이전 버전 보다 더 좋은 ..
    public void execute(Long postId, Long memberId) {
        var post = postReadService.getPost(postId);
        var member = memberReadService.getMember(memberId);
        postLikeWriteService.create(post, member);

    }
}
