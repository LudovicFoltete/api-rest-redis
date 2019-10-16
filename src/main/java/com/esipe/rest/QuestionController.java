package com.esipe.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RestController
public class QuestionController {

    //It's injected by constructor into the controller
    private final QuestionRepository repository;

    public QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    //Aggregate root

    @GetMapping("/questions")
    List<Question> all() {
        List<Question> questions = new ArrayList<>();
        repository.findAll().forEach(questions::add);
        return questions;
    }

    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    //Single item

    @GetMapping("/questions/{id}")
    Question one(@PathVariable String id) {
        return repository.findById(id).orElseThrow( () -> new QuestionNotFoundException(id));
    }

    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable String id) {
        return repository.findById(id).map(question -> {
            question.setQuestion(newQuestion.getQuestion());
            question.setChoiceList(newQuestion.getChoiceList());
            question.setAnswerIndex(newQuestion.getAnswerIndex());
            return repository.save(newQuestion);
        }).orElseGet( () -> {
            newQuestion.setId(id);
            return repository.save(newQuestion);
        });
    }

    @DeleteMapping("questions/{id}")
    void deleteQuestion(@PathVariable String id) {
        repository.deleteById(id);
    }

}
