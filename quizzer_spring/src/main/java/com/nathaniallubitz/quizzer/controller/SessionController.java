package com.nathaniallubitz.quizzer.controller;

import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/session")
public class SessionController {
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{id}")
    public QuestionPOJO getCurrentQuestion(@PathVariable Integer sessionId) {
        return sessionService.getCurrentQuestion(sessionId);
    }

}

