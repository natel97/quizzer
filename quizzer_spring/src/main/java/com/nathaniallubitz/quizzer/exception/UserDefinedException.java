package com.nathaniallubitz.quizzer.exception;

public abstract class UserDefinedException extends Exception {
    public abstract Integer getErrorCode();
    public abstract String getErrorMessage();
}
