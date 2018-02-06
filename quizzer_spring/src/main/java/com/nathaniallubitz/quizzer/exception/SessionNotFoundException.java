package com.nathaniallubitz.quizzer.exception;

public class SessionNotFoundException extends UserDefinedException {

    @Override
    public Integer getErrorCode() {
        return 404;
    }

    @Override
    public String getErrorMessage() {
        return "Session has either expired or does not exist";
    }
}
