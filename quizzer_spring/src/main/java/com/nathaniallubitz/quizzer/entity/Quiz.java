package com.nathaniallubitz.quizzer.entity;

import com.nathaniallubitz.quizzer.pojo.QuestionPOJO;
import com.nathaniallubitz.quizzer.pojo.QuizPOJO;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Quiz {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	@ManyToMany
	private List<Question> questions;
	@ManyToOne
	private User author;
	
	public Quiz() { }
	public Quiz(QuizPOJO q){
	    if(q.getId() != null)
		    this.id = q.getId();
		if(q.getTitle() !=  null)
		    this.title = q.getTitle();
		if(q.getQuestions() != null) {
            this.questions = q.getQuestions().stream().map(Question::new).collect(Collectors.toList());
        }
        if(q.getAuthor() != null) {
            this.author = new User(q.getAuthor());
        }
	}

	public Integer getId() { return id; }
	public String getTitle() { return title; }
	public List<Question> getQuestions() { return questions; }
	public User getAuthor() { return author; }

	public Quiz setId(Integer id) { this.id = id; return this; }
	public Quiz setTitle(String title) { this.title = title; return this; }
	public Quiz setQuestions(List<Question> questions) { this.questions = questions; return this; }
	public Quiz setAuthor(User author) { this.author = author; return this; }
    public Quiz addQuestion(Question question) { this.questions.add(question); return this; }
}
