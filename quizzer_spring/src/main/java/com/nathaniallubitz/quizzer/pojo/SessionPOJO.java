package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.Session;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SessionPOJO {
    private Integer id;
    private QuizPOJO quiz;
    private UserPOJO admin;
    private Date startTime;
    private Long questionLength;
    private Long gracePeriod;
    private List<QuestionPOJO> questions;

    public SessionPOJO() { }
    public SessionPOJO(Session s){
        this.id = s.getId();
        this.quiz = new QuizPOJO(s.getQuiz());
        this.admin = new UserPOJO(s.getAdmin());
        this.startTime = s.getStartTime();
        this.questionLength = s.getQuestionLength();
        this.gracePeriod = s.getGracePeriod();
        this.questions = new LinkedList<>(s.getQuestions().stream().map(QuestionPOJO::new).collect(Collectors.toList()));

    }

    public Integer getId() { return id; }
    public QuizPOJO getQuiz() { return quiz; }
    public UserPOJO getAdmin() { return admin; }
    public Date getStartTime() { return startTime; }
    public Long getQuestionLength() { return questionLength; }
    public Long getGracePeriod() { return gracePeriod; }
    public List<QuestionPOJO> getQuestions() { return this.questions; }

    public SessionPOJO setId(Integer id) { this.id = id; return this; }
    public SessionPOJO setQuiz(QuizPOJO quiz) { this.quiz = quiz; return this; }
    public SessionPOJO setAdmin(UserPOJO admin) { this.admin = admin; return this; }
    public SessionPOJO setStartTime(Date startTime) { this.startTime = startTime; return this; }
    public SessionPOJO setQuestionLength(Long questionLength) { this.questionLength = questionLength; return this; }
    public SessionPOJO setGracePeriod(Long gracePeriod) { this.gracePeriod = gracePeriod; return this; }
}
