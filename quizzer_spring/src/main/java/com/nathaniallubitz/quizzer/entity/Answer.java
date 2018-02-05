package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.AnswerPOJO;
import org.hibernate.sql.ANSICaseFragment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private Integer id;
	private String answer;
	
	public Answer() { }
	public Answer(AnswerPOJO a){
		this.id = a.getId();
		this.answer = a.getAnswer();
	}
	
	public Integer getId() { return id; }
	public String getAnswer() { return answer; }
	
	public Answer setId(Integer id) { this.id = id; return this; }
	public Answer setAnswer(String answer) { this.answer = answer; return this; }
}
