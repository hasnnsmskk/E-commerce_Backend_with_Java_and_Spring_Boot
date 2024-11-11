package com.workintech.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EcommerceException extends RuntimeException{

    private HttpStatus status;

    public EcommerceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
