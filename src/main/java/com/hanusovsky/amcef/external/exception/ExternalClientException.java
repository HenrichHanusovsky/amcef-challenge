package com.hanusovsky.amcef.external.exception;

/**
 * Custom exception used when External service returns 4xx response code
 */
public class ExternalClientException extends RuntimeException {
    public ExternalClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
