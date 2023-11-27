package com.module.crimelens.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.module.crimelens.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HashMap<String, String> response = new HashMap<>();
        
        e.getBindingResult().getFieldErrors().forEach(error -> {
           String fieldName = error.getField();
           String errorMessage = error.getDefaultMessage();

           response.put(fieldName, errorMessage);
        });

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }
}
