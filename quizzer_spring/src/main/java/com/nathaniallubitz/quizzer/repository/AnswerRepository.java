package com.nathaniallubitz.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniallubitz.quizzer.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
}
