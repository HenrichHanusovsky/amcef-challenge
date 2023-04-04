package com.hanusovsky.amcef.external.exception;

/**
 * Custom exception used when External service returns 5xx response code
 */
public class ExternalServerException extends RuntimeException {
    public ExternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
