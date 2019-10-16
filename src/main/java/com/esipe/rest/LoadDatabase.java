package com.esipe.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
//autocreate an Slf4j-based LoggerFactory as log, allowing us to log these newly created "questions"
@Slf4j
public class LoadDatabase {

    /*
     Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
     This runner will request a copy of the QuestionRepository just created.
     Using it, it will create 3 entities and store them.
     */
    @Bean
    CommandLineRunner initDatabase(QuestionRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Question("Quelle est la société derrière Android ?", Arrays.asList("Facebook", "Microsoft", "Apple", "Google"), 3)));
            log.info("Preloading " + repository.save(new Question("L'élément graphique à utiliser pour afficher du texte dans un layout est :", Arrays.asList("TextField","TextView", "Label", "EditText"), 1 )));
            log.info("Preloading " + repository.save(new Question("Comment s’appelle la classe Android qui centralise l’ensemble des identifiants de toutes les ressources du projet ?", Arrays.asList("R", "GlobalResources", "Activity", "MainConstants"), 0)));
        };
    }
}
