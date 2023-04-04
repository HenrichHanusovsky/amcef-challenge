package com.hanusovsky.amcef.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class AmcefException extends RuntimeException{

    @Getter
    private final Map.Entry<HttpStatus, String> code;
    public AmcefException(Map.Entry<HttpStatus, String> code) {
        this(code, null);
    }

    public AmcefException(Map.Entry<HttpStatus, String> code, Throwable cause) {
        super(cause);
        this.code = code;
    }
}
