package com.jcharles.portfolioApi.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
  
  public NotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
