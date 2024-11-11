package com.workintech.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EcommerceErrorResponse> handleException(EcommerceException witstagramException){
        EcommerceErrorResponse response = new EcommerceErrorResponse(
                witstagramException.getMessage(), LocalDateTime.now(),
                witstagramException.getStatus().value());

        return new ResponseEntity<>(response, witstagramException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<EcommerceErrorResponse> handleException(MethodArgumentNotValidException exception){
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        Map<String, List<String>> exceptionMap = new HashMap<>();
        for(FieldError error: errors){
            List<String> messages = exceptionMap.get(error.getField());

            if(messages == null){
                messages = new ArrayList<>();
            }

            messages.add(error.getDefaultMessage());
            exceptionMap.put(error.getField(), messages);
        }

        EcommerceErrorResponse response = new EcommerceErrorResponse(
                exceptionMap.toString(), LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<EcommerceErrorResponse> handleException(Exception exception){
        EcommerceErrorResponse response = new EcommerceErrorResponse(
                exception.getMessage(), LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
