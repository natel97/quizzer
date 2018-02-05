package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.Answer;

public class AnswerPOJO {
    private Integer id;
    private String answer;

    public AnswerPOJO() { }

    public AnswerPOJO(Answer answer) {
        this.id = answer.getId();
        this.answer = answer.getAnswer();
    }

    public Integer getId() { return id; }
    public String getAnswer() { return answer; }

    public AnswerPOJO setId(Integer id) { this.id = id; return this; }
    public AnswerPOJO setAnswer(String answer) { this.answer = answer; return this; }
}
