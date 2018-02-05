package com.nathaniallubitz.quizzer.pojo;

import com.nathaniallubitz.quizzer.entity.SelectedAnswers;

import java.util.List;
import java.util.stream.Collectors;

public class SelectedAnswersPOJO {
    private Integer id;
    private UserPOJO user;
    private List<AnswerPOJO> answers;
    private SessionPOJO session;
    private Integer score;

    public SelectedAnswersPOJO() { }
    public SelectedAnswersPOJO(SelectedAnswers s) {
        this.id = s.getId();
        this.user = new UserPOJO(s.getUser());
        this.answers = s.getAnswers().stream().map(AnswerPOJO::new).collect(Collectors.toList());
        this.session = new SessionPOJO(s.getSession());
        this.score = s.getScore();
    }

    public Integer getId() { return id; }
    public UserPOJO getUser() { return user; }
    public List<AnswerPOJO> getAnswers() { return answers; }
    public SessionPOJO getSession() { return session; }
    public Integer getScore() { return score; }

    public SelectedAnswersPOJO setId(Integer id) { this.id = id; return this; }
    public SelectedAnswersPOJO setUser(UserPOJO user) { this.user = user; return this; }
    public SelectedAnswersPOJO setAnswers(List<AnswerPOJO> answers) { this.answers = answers; return this; }
    public SelectedAnswersPOJO setSession(SessionPOJO session) { this.session = session; return this; }
    public SelectedAnswersPOJO setScore(Integer score) { this.score = score; return this; }
}
