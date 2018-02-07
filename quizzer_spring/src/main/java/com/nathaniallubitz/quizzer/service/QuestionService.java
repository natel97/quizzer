package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.entity.Answer;
import com.nathaniallubitz.quizzer.entity.Question;
import com.nathaniallubitz.quizzer.entity.Quiz;
import com.nathaniallubitz.quizzer.pojo.AnswerPOJO;
import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.pojo.QuizPOJO;
import com.nathaniallubitz.quizzer.repository.AnswerRepository;
import com.nathaniallubitz.quizzer.repository.QuestionRepository;
import com.nathaniallubitz.quizzer.repository.QuizRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;
    private AnswerRepository answerRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.answerRepository = answerRepository;
    }

    public QuestionPOJO getQuestionById(Integer id) {
        return new QuestionPOJO(questionRepository.findOne(id));
    }

    @Transactional
    public QuizPOJO addQuestion(QuestionPOJO questionPOJO, Integer quizId){
        Question question = new Question(questionPOJO);
        if(question.getAnswers() != null){
            question.getAnswers().forEach(answerRepository::save);
        }
        if(question.getCorrectAnswer() != null){
            answerRepository.save(question.getCorrectAnswer());
        }

        questionRepository.save(question);
        Quiz quiz = quizRepository.findOne(quizId).addQuestion(question);
        quizRepository.save(quiz);
        return new QuizPOJO(quiz);
    }

    public QuestionPOJO addAnswerToQuestion(Integer id, AnswerPOJO answer) {
        Answer a = new Answer(answer);
        answerRepository.save(a);
        Question question = questionRepository.findOne(id).addAnswer(a);
        questionRepository.save(question);
        return new QuestionPOJO(question);
    }

    public QuestionPOJO setCorrectAnswer(Integer id, AnswerPOJO answer) {
        Answer a = answerRepository.findOne(answer.getId());
        return new QuestionPOJO(questionRepository.save(questionRepository.findOne(id).setCorrectAnswer(a == null ? new Answer(answer) : a)));
    }
}
