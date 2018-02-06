package com.nathaniallubitz.quizzer.exception;

public class PasswordMismatchException extends UserDefinedException{
    @Override
    public Integer getErrorCode() {
        return 404;
    }

    @Override
    public String getErrorMessage() {
        return "Your username and password did not match";
    }
}
