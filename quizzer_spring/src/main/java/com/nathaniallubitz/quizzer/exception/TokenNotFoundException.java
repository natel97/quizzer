package com.nathaniallubitz.quizzer.exception;

public class TokenNotFoundException extends UserDefinedException {
    @Override
    public Integer getErrorCode() {
        return 404;
    }

    @Override
    public String getErrorMessage() {
        return "The token has either expired or does not exist";
    }
}
