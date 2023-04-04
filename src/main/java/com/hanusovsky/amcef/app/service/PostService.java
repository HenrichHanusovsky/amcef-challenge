package com.hanusovsky.amcef.app.service;

import com.hanusovsky.amcef.app.entity.Post;
import com.hanusovsky.amcef.external.service.ExternalService;
import com.hanusovsky.amcef.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ExternalService externalService;

    public Post getPostById(){
        System.out.println(externalService.getPosts());

        return postRepository.findById(1L).orElseThrow();
    }

}
