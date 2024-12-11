package com.university.university_management_system.exceptions;

public class ApiException extends RuntimeException {
    private final String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
