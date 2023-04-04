package com.hanusovsky.amcef.external.service;

import com.hanusovsky.amcef.external.dto.ExternalPost;
import com.hanusovsky.amcef.external.dto.ExternalUser;
import com.hanusovsky.amcef.external.exception.ExternalClientException;
import com.hanusovsky.amcef.external.exception.ExternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalServiceImpl implements ExternalService {
    private static final String URL = "https://jsonplaceholder.typicode.com/";
    private static final String PATH_POSTS = "posts";
    private static final String PATH_USERS = "users";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ExternalPost getPost(long postId) {
        String url = String.format("%s%s/%d", URL, PATH_POSTS, postId);
        return this.executeAndRaiseOrReturn(url, ExternalPost.class);
    }

    @Override
    public ExternalUser getUser(long userId) {
        String url = String.format("%s%s/%d", URL, PATH_USERS, userId);
        return this.executeAndRaiseOrReturn(url, ExternalUser.class);
    }

    /**
     * Method to execute the call and parse the response (raising error if any occurred)
     * This method is created on the best guess, based on experience with external API there might be more edge cases
     * to handle and this behavior could be extracted to some error handler
     * @param url URL you want to fetch
     * @param responseClass class to which the response should be parsed
     * @param <T>
     * @return Response in form of responseClass format if found, null if 404 was response and raises error if 4xx
     * or 5xx response was given
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
