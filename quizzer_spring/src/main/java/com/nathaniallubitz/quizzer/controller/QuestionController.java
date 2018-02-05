package com.nathaniallubitz.quizzer.controller;

import com.nathaniallubitz.quizzer.pojo.AnswerPOJO;
import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
    QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public QuestionPOJO getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }
    @PostMapping("/id")
    public QuestionPOJO addAnswerToQuestion(@PathVariable Integer id, @RequestBody AnswerPOJO answer){
        return questionService.addAnswerToQuestion(id, answer);
    }





}
