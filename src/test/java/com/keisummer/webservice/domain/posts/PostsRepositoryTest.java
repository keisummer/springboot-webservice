package com.keisummer.webservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void afterEach() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_and_load() {
        //given
        postsRepository.save(Posts.builder()
                .title("타이틀")
                .content("내용")
                .author("keisummer")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("타이틀");
        assertThat(posts.getContent()).isEqualTo("내용");
        assertThat(posts.getAuthor()).isEqualTo("keisummer");
    }

    @Test
    public void BaseTimeEntity_Test () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("타이틀")
                .content("내용")
                .author("keisummer")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}