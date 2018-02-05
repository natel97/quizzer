package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Session;
import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public QuestionPOJO getCurrentQuestion(Integer sessionId) {
        return new QuestionPOJO(sessionRepository.findOne(sessionId).getQuestions().get(1));
    }
    public void nextQuestion(Integer sessionId){
        Session s = sessionRepository.findOne(sessionId);
        s.removeQuestion();
        sessionRepository.save(s.removeQuestion());
    }
}
