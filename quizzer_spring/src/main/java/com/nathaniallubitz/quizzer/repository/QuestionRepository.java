package com.nathaniallubitz.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniallubitz.quizzer.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
}