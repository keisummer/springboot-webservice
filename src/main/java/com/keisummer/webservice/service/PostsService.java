package com.keisummer.webservice.service;

import com.keisummer.webservice.domain.posts.Posts;
import com.keisummer.webservice.domain.posts.PostsRepository;
import com.keisummer.webservice.dto.PostsMainResponseDto;
import com.keisummer.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        Posts posts = dto.toEntity();

        System.out.println(posts.getId());
        return postsRepository.save(posts).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAll() {
        return postsRepository.findAll().stream().map(PostsMainResponseDto::new).collect(Collectors.toList());
    }
}
