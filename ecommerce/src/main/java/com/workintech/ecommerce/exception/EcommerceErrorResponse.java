package com.workintech.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class EcommerceErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private int status;
}
