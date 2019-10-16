package com.esipe.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
When an EmployeeNotFoundException is thrown,
this extra tidbit of Spring MVC configuration is used to render an HTTP 404:
 */
@ControllerAdvice
public class QuestionNotFoundAdvice {

    //signals that this advice is rendered straight into the response body.
    @ResponseBody
    //configures the advice to only respond if an QuestionNotFoundException is thrown.
    @ExceptionHandler(QuestionNotFoundException.class)
    //says to issue an HTTP 404 error.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String questionNotFoundHandler(QuestionNotFoundException ex) {
        return ex.getMessage();
    }
}
