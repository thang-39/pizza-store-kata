package com.mesoneer.pizzastore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(List.of(ex.getMessage()));
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
