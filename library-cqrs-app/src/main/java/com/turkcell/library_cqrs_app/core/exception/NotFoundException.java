package com.turkcell.library_cqrs_app.core.exception;

public class NotFoundException extends BusinessException {
    public NotFoundException(String message) {
        super(message);
    }

}
