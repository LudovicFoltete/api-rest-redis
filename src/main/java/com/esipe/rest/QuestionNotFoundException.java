package com.esipe.rest;

public class QuestionNotFoundException extends RuntimeException {

    //An exception used to indicate when an question is looked up but not found.
    QuestionNotFoundException(String id) {
        super("Could not find question " + id);
    }
}
