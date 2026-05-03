package com.turkcell.library_cqrs_app.core.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
                int status,
                List<String> message,
                LocalDateTime timestamp) {

}
