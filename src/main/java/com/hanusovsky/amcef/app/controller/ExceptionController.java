package com.hanusovsky.amcef.app.controller;

import com.hanusovsky.amcef.app.exception.AmcefException;
import com.hanusovsky.amcef.external.exception.ExternalClientException;
import com.hanusovsky.amcef.external.exception.ExternalServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ExternalServerException.class, ExternalClientException.class})
    protected ResponseEntity<Object> handleExternalExceptions(RuntimeException ex, WebRequest request) {
        return this.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {AmcefException.class})
    protected ResponseEntity<Object> handleAmcefException(AmcefException ex, WebRequest request) {
        return this.handleExceptionInternal(ex, ex.getCode().getValue(), new HttpHeaders(), ex.getCode().getKey(), request);
    }
}
