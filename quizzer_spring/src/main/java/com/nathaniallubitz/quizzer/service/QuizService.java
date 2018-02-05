package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Quiz;
import com.nathaniallubitz.quizzer.pojo.QuizPOJO;
import com.nathaniallubitz.quizzer.repository.QuizRepository;
import com.nathaniallubitz.quizzer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private QuizRepository quizRepository;
    private UserRepository userRepository;

    public QuizService(QuizRepository quizRepository, UserRepository userRepository){
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    public QuizPOJO getQuizById(Integer id){
        return new QuizPOJO(quizRepository.findOne(id));
    }

    public QuizPOJO addQuiz(QuizPOJO quizPOJO){
        Quiz quiz = new Quiz(quizPOJO);
        quiz.setAuthor(userRepository.findOne(quiz.getAuthor().getId()));
        quizRepository.save(quiz);
        return new QuizPOJO(quiz);
    }

    public List<QuizPOJO> getAllQuizzes() {
        return quizRepository.findAll().stream().map(QuizPOJO::new).collect(Collectors.toList());
    }
}
