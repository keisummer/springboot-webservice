package com.keisummer.webservice.service;

import com.keisummer.webservice.domain.posts.Posts;
import com.keisummer.webservice.domain.posts.PostsRepository;
import com.keisummer.webservice.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void afterEach() {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("Dto데이터가_posts테이블에_저장된다")
    public void save_test () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("타이틀")
                .content("테스트")
                .author("keisummer")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}