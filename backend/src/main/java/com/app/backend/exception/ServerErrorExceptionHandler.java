package com.app.backend.exception;

public class ServerErrorExceptionHandler extends RuntimeException{
    public ServerErrorExceptionHandler(String message){
        super(message);
    }
}
