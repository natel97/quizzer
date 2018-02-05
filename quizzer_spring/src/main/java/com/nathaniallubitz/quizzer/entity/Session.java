package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.SessionPOJO;
import javafx.scene.layout.Priority;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
public class Session {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Quiz quiz;
	@ManyToOne
	private User admin;
	private Date startTime;
	private Long questionLength;
	private Long gracePeriod;
	@OneToMany
	private List<Question> questions;
	
	public Session() { }
	public Session(SessionPOJO s){
		this.id = s.getId();
		this.quiz = new Quiz(s.getQuiz());
		this.admin = new User(s.getAdmin());
		this.startTime = s.getStartTime();
		this.questionLength = s.getQuestionLength();
		this.gracePeriod = s.getGracePeriod();
		this.questions = new LinkedList<Question>(s.getQuestions().stream().map(Question::new).collect(Collectors.toList()));
	}

	public Integer getId() { return id; }
	public Quiz getQuiz() { return quiz; }
	public User getAdmin() { return admin; }
	public Date getStartTime() { return startTime; }
	public Long getQuestionLength() { return questionLength; }
	public Long getGracePeriod() { return gracePeriod; }
	public List<Question> getQuestions() { return questions; }

	public Session setId(Integer id) { this.id = id; return this; }
	public Session setQuiz(Quiz quiz) { this.quiz = quiz; return this; }
	public Session setAdmin(User admin) { this.admin = admin; return this; }
	public Session setStartTime(Date startTime) { this.startTime = startTime; return this; }
	public Session setQuestionLength(Long questionLength) { this.questionLength = questionLength; return this; }
	public Session setGracePeriod(Long gracePeriod) { this.gracePeriod = gracePeriod; return this; }
	public Session setSessionQuestions(List<Question> sessionQuestions) { this.questions = sessionQuestions; return this; }
	public Session removeQuestion() { this.questions.remove(1); return this; }

}
