package com.hanusovsky.amcef.external.exception;

public class ExternalClientException extends RuntimeException {
    public ExternalClientException(String message, Throwable cause){
        super(message, cause);
    }
}
