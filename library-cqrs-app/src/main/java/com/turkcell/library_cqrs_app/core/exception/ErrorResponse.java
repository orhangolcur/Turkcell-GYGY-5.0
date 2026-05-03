package com.turkcell.library_cqrs_app.core.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp) {

}
