package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.AnswerPOJO;
import com.nathaniallubitz.quizzer.pojo.SelectedAnswersPOJO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SelectedAnswers {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private User user;
	@ManyToMany
	private List<Answer> answers;
	@ManyToOne
	private Session session;
	private Integer score;
	
	public SelectedAnswers() { }
	public SelectedAnswers(SelectedAnswersPOJO s) {
		this.id = s.getId();
		this.user = new User(s.getUser());
		this.answers = s.getAnswers().stream().map(Answer::new).collect(Collectors.toList());
		this.session = new Session(s.getSession());
		this.score = s.getScore();
	}
	
	public Integer getId() { return id; }
	public User getUser() { return user; }
	public List<Answer> getAnswers() { return answers; }
	public Session getSession() { return session; }
	public Integer getScore() { return score; }
	
	public SelectedAnswers setId(Integer id) { this.id = id; return this; }
	public SelectedAnswers setUser(User user) { this.user = user; return this; }
	public SelectedAnswers setAnswers(List<Answer> answers) { this.answers = answers; return this; }
	public SelectedAnswers setSession(Session session) { this.session = session; return this; }
	public SelectedAnswers setScore(Integer score) { this.score = score; return this; }
}
