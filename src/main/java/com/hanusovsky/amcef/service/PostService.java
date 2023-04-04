package com.hanusovsky.amcef.service;

import com.hanusovsky.amcef.entity.Post;
import com.hanusovsky.amcef.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getPostById(){
        return postRepository.findById(1L).orElseThrow();
    }

}
