package com.turkcell.library_cqrs_app.core.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

}
