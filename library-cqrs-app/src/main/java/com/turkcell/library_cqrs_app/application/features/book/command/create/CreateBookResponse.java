package com.turkcell.library_cqrs_app.application.features.book.command.create;

import java.util.UUID;

public record CreateBookResponse(
        UUID id,
        String isbn,
        String title,
        int stock,
        int publishYear) {
}
