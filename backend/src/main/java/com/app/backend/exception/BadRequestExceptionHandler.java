package com.app.backend.exception;

public class BadRequestExceptionHandler extends RuntimeException{
    public BadRequestExceptionHandler(String message){
        super(message);
    }
}
