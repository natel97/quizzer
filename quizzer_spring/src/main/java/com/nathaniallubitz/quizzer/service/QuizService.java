package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Quiz;
import com.nathaniallubitz.quizzer.entity.Token;
import com.nathaniallubitz.quizzer.exception.TokenNotFoundException;
import com.nathaniallubitz.quizzer.pojo.QuizPOJO;
import com.nathaniallubitz.quizzer.repository.QuizRepository;
import com.nathaniallubitz.quizzer.repository.TokenRepository;
import com.nathaniallubitz.quizzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private QuizRepository quizRepository;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public QuizService(QuizRepository quizRepository, UserRepository userRepository, TokenRepository tokenRepository){
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }


    public QuizPOJO getQuizById(Integer id){
        return new QuizPOJO(quizRepository.findOne(id));
    }

    public QuizPOJO addQuiz(QuizPOJO quizPOJO, String token) throws TokenNotFoundException {
        Quiz quiz = new Quiz(quizPOJO);
        Token t = tokenRepository.findTokenByToken(token);
        if(t == null) {
            throw new TokenNotFoundException();
        }
        quiz.setAuthor(t.getUser());
        quizRepository.save(quiz);
        return new QuizPOJO(quiz);
    }

    public List<QuizPOJO> getAllQuizzes() {
        return quizRepository.findAll().stream().map(QuizPOJO::new).collect(Collectors.toList());
    }
}
