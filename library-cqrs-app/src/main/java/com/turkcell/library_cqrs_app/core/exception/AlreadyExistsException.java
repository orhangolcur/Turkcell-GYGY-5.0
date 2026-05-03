package com.turkcell.library_cqrs_app.core.exception;

public class AlreadyExistsException extends BusinessException {
    public AlreadyExistsException(String message) {
        super(message);
    }

}
