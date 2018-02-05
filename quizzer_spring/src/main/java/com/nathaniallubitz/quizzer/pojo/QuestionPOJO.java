package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionPOJO {
    public QuestionPOJO() {}

    public QuestionPOJO(Question question) {
        this.id = question.getId();
        this.question = question.getQuestion();
        if(question.getCorrectAnswer() != null) {
            this.correctAnswer = new AnswerPOJO(question.getCorrectAnswer());
        }
        this.answers = question.getAnswers().stream().map(AnswerPOJO::new).collect(Collectors.toList());
    }

    private Integer id;
    private String question;
    private AnswerPOJO correctAnswer;
    private List<AnswerPOJO> answers;

    public QuestionPOJO setId(Integer id) { this.id = id; return this; }
    public QuestionPOJO setQuestion(String question) { this.question = question; return this; }
    public QuestionPOJO setCorrectAnswer(AnswerPOJO a) { this.correctAnswer = a; return this; }
    public QuestionPOJO setAnswers(List<AnswerPOJO> a) { this.answers = a; return this; }


    public Integer getId() { return this.id; }
    public String getQuestion() { return this.question; }
    public AnswerPOJO getCorrectAnswer() { return this.correctAnswer; }
    public List<AnswerPOJO> getAnswers() { return this.answers; }
}
