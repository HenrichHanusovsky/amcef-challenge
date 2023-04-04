package com.hanusovsky.amcef.app.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;


/**
 * Exception code for all Amcef application exceptions
 * Consists of HTTPStatus, which should be returned to client and meaningful,
 * human-readable message describing the error.
 */
public class AmcefExceptionCode {
    public static final Map.Entry<HttpStatus, String> EXTERNAL_USER_NOT_FOUND = Map.entry(HttpStatus.UNPROCESSABLE_ENTITY, "User with given ID was not found in external service");
    public static final Map.Entry<HttpStatus, String> POST_NOT_FOUND = Map.entry(HttpStatus.NOT_FOUND, "Post with given ID was not found");
}
