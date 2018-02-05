package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.Quiz;

import java.util.List;
import java.util.stream.Collectors;

public class QuizPOJO {
    private Integer id;
    private String title;
    private List<QuestionPOJO> questions;
    private UserPOJO author;

    public QuizPOJO() { }
    public QuizPOJO(Quiz q){
        this.id = q.getId();
        this.title = q.getTitle();
        if(q.getQuestions() != null) {
            this.questions = q.getQuestions().stream().map(QuestionPOJO::new).collect(Collectors.toList());
        }
        this.author = new UserPOJO(q.getAuthor());
    }



    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public List<QuestionPOJO> getQuestions() { return questions; }
    public UserPOJO getAuthor() { return author; }

    public QuizPOJO setId(Integer id) { this.id = id; return this; }
    public QuizPOJO setTitle(String title) { this.title = title; return this; }
    public QuizPOJO setQuestions(List<QuestionPOJO> questions) { this.questions = questions; return this; }
    public QuizPOJO setAuthor(UserPOJO author) { this.author = author; return this; }

}
