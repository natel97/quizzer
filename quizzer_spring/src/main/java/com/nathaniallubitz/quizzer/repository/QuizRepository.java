package com.nathaniallubitz.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniallubitz.quizzer.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	
}
