package com.example.fastcampusmysql.domain.post.service;

import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.entity.Post;
import com.example.fastcampusmysql.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostWriteService {

    final private PostRepository postRepository;


    public Long create (PostCommand command) {
        var post = Post.builder()
                .memberId(command.memberId())
                .contents(command.contents())
                .build();

        return postRepository.save(post).getId();
    }

    @Transactional
    public void likePost(Long postId) {
        // 이 구간이 동시성 이슈 생길 수 있는 젤 좋은부분
        // 조회 -> 변경 -> 저장
        // 두개의 쓰레드가 들어왔을때..
        // 디버그 모드로 테스트할때는 왼쪽 마우스 클릭 해서 Thread 이용해 동시성 테스트를 할 수 있음
        // 동시성 을 막을 수 있는게 Select for update 잠금 획득 방법을 통해 막을 수 있다.
        var post = postRepository.findById(postId, true ).orElseThrow();
        post.incrementLikecount();
        postRepository.save(post);
    }


    public void likePostByOptimisticLock(Long postId) {
        var post = postRepository.findById(postId, false ).orElseThrow();
        post.incrementLikecount();
        postRepository.save(post);
    }
}
