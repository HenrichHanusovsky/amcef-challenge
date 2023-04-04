package com.hanusovsky.amcef.app.service;

import com.hanusovsky.amcef.app.dto.PostCreate;
import com.hanusovsky.amcef.app.dto.PostUpdate;
import com.hanusovsky.amcef.app.entity.Post;
import com.hanusovsky.amcef.app.exception.AmcefException;
import com.hanusovsky.amcef.app.exception.AmcefExceptionCode;
import com.hanusovsky.amcef.app.repository.PostRepository;
import com.hanusovsky.amcef.external.dto.ExternalPost;
import com.hanusovsky.amcef.external.dto.ExternalUser;
import com.hanusovsky.amcef.external.service.ExternalServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ExternalServiceImpl externalService;

    @Autowired
    private ModelMapper modelMapper;

    public Post addPost(PostCreate postPayload) {
        Post post = modelMapper.map(postPayload, Post.class);
        ExternalUser user = this.externalService.getUser(post.getUserId());
        if (user == null) {
            throw new AmcefException(AmcefExceptionCode.EXTERNAL_USER_NOT_FOUND);
        }
        return this.postRepository.save(post);
    }

    public Post getPost(long postId) {
        return this.postRepository.findById(postId).orElseGet(
                () -> this.fetchFromExternalServiceAndSave(postId)
        );
    }

    public Post updatePost(long postId, PostUpdate postPayload) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new AmcefException(AmcefExceptionCode.POST_NOT_FOUND));
        this.modelMapper.map(postPayload, post);
        return this.postRepository.save(post);
    }

    public void deletePost(long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new AmcefException(AmcefExceptionCode.POST_NOT_FOUND));
        this.postRepository.delete(post);
    }

    public List<Post> getPostsForUser(long userId) {
        return this.postRepository.findByUserId(userId);
    }

    private Post fetchFromExternalServiceAndSave(long postId) {
        ExternalPost post = this.externalService.getPost(postId);
        if (post == null) {
            return null;
        }
        return this.postRepository.save(this.modelMapper.map(post, Post.class));
    }

}
