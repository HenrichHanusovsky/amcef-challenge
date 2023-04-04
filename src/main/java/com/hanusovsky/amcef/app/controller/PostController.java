package com.hanusovsky.amcef.app.controller;

import com.hanusovsky.amcef.app.entity.Post;
import com.hanusovsky.amcef.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
