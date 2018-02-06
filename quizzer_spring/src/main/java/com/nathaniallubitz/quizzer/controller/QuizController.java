package com.nathaniallubitz.quizzer.controller;

import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.pojo.QuizPOJO;
import com.nathaniallubitz.quizzer.service.QuestionService;
import com.nathaniallubitz.quizzer.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Controller
@RestController
@RequestMapping("quiz")
public class QuizController {
    private QuizService quizService;
    private QuestionService questionService;
    public QuizController(QuizService quizService, QuestionService questionService){
        this.quizService = quizService;
        this.questionService = questionService;
    }



    @GetMapping("/{id}")
    public QuizPOJO getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @GetMapping
    public List<QuizPOJO> getQuizzes(){
        return quizService.getAllQuizzes();
    }

    @PostMapping
    public QuizPOJO newQuiz(@RequestBody QuizPOJO quiz){
        return quizService.addQuiz(quiz);
    }

    @PostMapping("/{id}")
    public QuizPOJO addQuestionToQuiz(@PathVariable Integer id, @RequestBody QuestionPOJO question){
        return questionService.addQuestion(question, id);
    }

}
