package com.university.university_management_system.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public ApiException(String message,HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
