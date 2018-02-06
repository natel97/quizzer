package com.nathaniallubitz.quizzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuizzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizzerApplication.class, args);
    }
}
