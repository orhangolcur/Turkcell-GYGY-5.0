package com.turkcell.library_cqrs_app.application.features.book.command.delete;

import java.util.UUID;

public record DeleteBookResponse(
        UUID id,
        String message) {

}
