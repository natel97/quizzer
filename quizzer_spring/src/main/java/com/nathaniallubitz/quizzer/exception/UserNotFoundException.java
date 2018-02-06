package com.nathaniallubitz.quizzer.exception;

public class UserNotFoundException extends UserDefinedException {
    @Override
    public Integer getErrorCode() {
        return 404;
    }

    @Override
    public String getErrorMessage() {
        return "The user does not exist";
    }
}
