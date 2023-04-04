package com.hanusovsky.amcef.external.service;

import com.hanusovsky.amcef.external.dto.ExternalPost;
import com.hanusovsky.amcef.external.dto.ExternalUser;
import com.hanusovsky.amcef.external.exception.ExternalClientException;
import com.hanusovsky.amcef.external.exception.ExternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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

    public ExternalPost getPost(long postId) {
        String url = String.format("%s%s/%d", URL, PATH_POSTS, postId);
        return this.executeAndRaiseOrReturn(url, ExternalPost.class);
    }

    public ExternalUser getUser(long userId) {
        String url = String.format("%s%s/%d", URL, PATH_USERS, userId);
        return this.executeAndRaiseOrReturn(url, ExternalUser.class);
    }

    /**
     * Method to execute the call and parse the response (raising error if any occurred)
     * NOTE: This is not based on actual behavior, since this is unknown to me, just some placeholder for potential problems
     * @param url
     * @param responseClass
     * @param <T>
     * @return
     */
    private <T> T executeAndRaiseOrReturn(String url, Class<T> responseClass) {
        ResponseEntity<T> response;
        try {
            response = this.restTemplate.getForEntity(url, responseClass);
        } catch (HttpClientErrorException exc) {
            if (exc.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            }
            throw new ExternalClientException("Client error while communicating with external service", exc);
        } catch (HttpServerErrorException exc) {
            throw new ExternalServerException("Server error while communicating with external service", exc);
        }
        return response.getBody();
    }
}
