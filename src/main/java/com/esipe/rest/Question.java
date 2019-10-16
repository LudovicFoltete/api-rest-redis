package com.esipe.rest;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

//create all the getters, setters, equals, hash and toString methods, based on the fields
@Data
@RedisHash("Question")
class Question implements Serializable {

    private String id;
    private String question;
    List<String> choiceList;
    private int answerIndex;

    //JPA forced a default constructor for entity
    Question() {}

    Question(String question, List<String> choiceList, int answerIndex) {
        this.question = question;
        this.choiceList = choiceList;
        this.answerIndex = answerIndex;
    }
}
