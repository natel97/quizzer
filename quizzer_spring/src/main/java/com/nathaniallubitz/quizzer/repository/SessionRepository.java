package com.nathaniallubitz.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniallubitz.quizzer.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
	
}