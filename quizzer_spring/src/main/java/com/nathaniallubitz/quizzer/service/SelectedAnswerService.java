package com.nathaniallubitz.quizzer.service;

import com.nathaniallubitz.quizzer.repository.SelectedAnswersRepository;
import org.springframework.stereotype.Service;

@Service
public class SelectedAnswerService {
    private SelectedAnswersRepository selectedAnswersRepository;

    public SelectedAnswerService(SelectedAnswersRepository selectedAnswersRepository){
        this.selectedAnswersRepository = selectedAnswersRepository;
    }

    //Todo: Set Selected Answer -- Get Selected Answer by user and question -- get if the answer has been set
}
