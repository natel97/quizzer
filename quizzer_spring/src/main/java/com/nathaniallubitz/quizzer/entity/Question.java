package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	public Question() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	private String question;
	@ManyToOne
	private Answer correctAnswer;
	@OneToMany
	private List<Answer> answers;

	public Question(QuestionPOJO question) {
			this.id = question.getId();
			this.question = question.getQuestion();
			if(question.getCorrectAnswer() != null) {
				this.correctAnswer = new Answer(question.getCorrectAnswer());
			}
			if(question.getAnswers() != null) {
				this.answers = question.getAnswers().stream().map(Answer::new).collect(Collectors.toList());
			}
	}

	public Question addAnswer(Answer a) { this.answers.add(a); return this; }
	public Question setId(Integer id) { this.id = id; return this; }
	public Question setQuestion(String question) { this.question = question; return this; }
	public Question setCorrectAnswer(Answer a) { this.correctAnswer = a; return this; }
	public Question setAnswers(List<Answer> a) { this.answers = a; return this; }
	
	
	public Integer getId() { return this.id; }
	public String getQuestion() { return this.question; }
	public Answer getCorrectAnswer() { return this.correctAnswer; }
	public List<Answer> getAnswers() { return this.answers; }
}
