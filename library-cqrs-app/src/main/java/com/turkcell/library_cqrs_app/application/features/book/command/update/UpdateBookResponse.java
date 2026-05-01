package com.turkcell.library_cqrs_app.application.features.book.command.update;

import java.util.UUID;

public record UpdateBookResponse(
        UUID id,
        String title,
        String isbn,
        int stock,
        int publishYear) {

}
