package com.jcharles.portfolioApi.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationError(MethodArgumentNotValidException e) {
    Map<String, String> errorDetails = new HashMap<>();

    e.getBindingResult()
    .getFieldErrors()
    .forEach(fieldError ->
      errorDetails.put(fieldError.getField(), fieldError.getDefaultMessage())
    );

    return ResponseEntity.badRequest().body(errorDetails);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIntegrityError(IllegalArgumentException e) {
    String errorMessage = e.getMessage();
    
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }
}
