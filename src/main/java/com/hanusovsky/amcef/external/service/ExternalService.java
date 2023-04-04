package com.hanusovsky.amcef.external.service;

import com.hanusovsky.amcef.external.dto.ExternalPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalService {
    private static final String URL = "https://jsonplaceholder.typicode.com/";
    private static final String PATH_POSTS = "posts";
    private static final String PATH_USERS = "users";

    @Autowired
    private RestTemplate restTemplate;

    public List<ExternalPost> getPosts() {
        String url = URL + PATH_POSTS;
        ResponseEntity<ExternalPost[]> response = this.restTemplate.getForEntity(url, ExternalPost[].class);
        if (!response.getStatusCode().is2xxSuccessful()) {

        }
        ExternalPost[] body = response.getBody();
        return body == null ? Collections.emptyList() : Arrays.asList(response.getBody());
    }

}
