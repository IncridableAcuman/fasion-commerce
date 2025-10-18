package com.app.backend.exception;

public class UnAuthorizeExceptionHandler extends RuntimeException{
    public UnAuthorizeExceptionHandler(String message){
        super(message);
    }
}
