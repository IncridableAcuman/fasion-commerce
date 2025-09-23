package com.app.backend.exception;

public class ForbiddenExceptionHandler extends RuntimeException{
    public ForbiddenExceptionHandler(String message){
        super(message);
    }
}
