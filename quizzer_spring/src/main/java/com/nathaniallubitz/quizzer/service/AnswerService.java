package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Answer;
import com.nathaniallubitz.quizzer.pojo.AnswerPOJO;
import com.nathaniallubitz.quizzer.repository.AnswerRepository;
import com.nathaniallubitz.quizzer.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AnswerService {
    AnswerRepository answerRepository;
    QuestionRepository questionRepository;
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    public Integer addAnswer(AnswerPOJO answerPOJO, Integer questionId){
        Answer answer = new Answer(answerPOJO);
        answerRepository.save(answer);
        questionRepository.save(questionRepository.findOne(questionId).addAnswer(answer));
        return answer.getId();
    }

}
