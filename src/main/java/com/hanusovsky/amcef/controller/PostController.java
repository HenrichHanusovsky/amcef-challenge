package com.hanusovsky.amcef.controller;

import com.hanusovsky.amcef.entity.Post;
import com.hanusovsky.amcef.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Post getPosts() {
        return postService.getPostById();
    }

    @PostMapping
    public void addPost(@RequestBody Post post) {
        System.out.println(post);
    }
}
