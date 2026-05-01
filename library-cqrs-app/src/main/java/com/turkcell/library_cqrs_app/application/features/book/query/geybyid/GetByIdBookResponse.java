package com.turkcell.library_cqrs_app.application.features.book.query.geybyid;

import java.util.UUID;

public record GetByIdBookResponse(
        UUID id,
        String title,
        String isbn,
        int stock,
        int publishYear) {

}
