package com.msvc.user.utils.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.msvc.user.api.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionController {

  @ExceptionHandler (ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException exception) {
    String message = exception.getMessage();

    ApiResponse response = ApiResponse.builder().message(message)
    .success(true)
    .status(HttpStatus.NOT_FOUND)
    .build();

    return new ResponseEntity<>(response, response.getStatus());
  }
}
