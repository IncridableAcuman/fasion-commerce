package com.app.backend.exception;

public class NotFoundExceptionHandler extends RuntimeException{
    public NotFoundExceptionHandler(String message){
        super(message);
    }
}
