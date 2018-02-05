package com.nathaniallubitz.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniallubitz.quizzer.entity.SelectedAnswers;

@Repository
public interface SelectedAnswersRepository extends JpaRepository<SelectedAnswers, Integer> {
	
}