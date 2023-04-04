package com.hanusovsky.amcef.external.service;

import com.hanusovsky.amcef.external.dto.ExternalPost;
import com.hanusovsky.amcef.external.dto.ExternalUser;

public interface ExternalService {
    /**
     * Returns post from External service, based on post ID
     * @param postId ID of post you want to retrieve
     * @return post if found, null if 404 was returned
     */
    ExternalPost getPost(long postId);

    /**
     * Returns user from External service, based on user ID
     * @param userId ID of user you want to retrieve
     * @return user if found, null if 404 was returned
     */
    ExternalUser getUser(long userId);
}
