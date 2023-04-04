package com.hanusovsky.amcef.external.exception;

public class ExternalServerException extends RuntimeException {
    public ExternalServerException(String message, Throwable cause){
        super(message, cause);
    }
}
