package com.app.backend.exception;

import com.app.backend.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestExceptionHandler.class)
    public ResponseEntity<ErrorResponse> badRequest(BadRequestExceptionHandler e, HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ResponseEntity<ErrorResponse> notFound(NotFoundExceptionHandler e,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(ServerErrorExceptionHandler.class)
    public ResponseEntity<ErrorResponse> serverError(ServerErrorExceptionHandler e,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    @ExceptionHandler(ForbiddenExceptionHandler.class)
    public ResponseEntity<ErrorResponse> forbiddenError(ForbiddenExceptionHandler e,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
    @ExceptionHandler(UnAuthorizeExceptionHandler.class)
    public ResponseEntity<ErrorResponse> unAuthorize(UnAuthorizeExceptionHandler e,HttpServletRequest request){
        ErrorResponse response=new ErrorResponse(
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
