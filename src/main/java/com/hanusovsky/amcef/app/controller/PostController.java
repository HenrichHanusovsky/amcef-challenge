package com.hanusovsky.amcef.app.controller;

import com.hanusovsky.amcef.app.dto.PostCreate;
import com.hanusovsky.amcef.app.dto.PostUpdate;
import com.hanusovsky.amcef.app.entity.Post;
import com.hanusovsky.amcef.app.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@Valid @RequestBody PostCreate post) {
        return this.postService.addPost(post);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable long postId) {
        return this.postService.getPost(postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable long postId) {
        this.postService.deletePost(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable long postId, @Valid @RequestBody PostUpdate post) {
        return this.postService.updatePost(postId, post);
    }

    @GetMapping(value = "/user/{userId}")
    public List<Post> getPosts(@PathVariable int userId) {
        return this.postService.getPostsForUser(userId);
    }
}
