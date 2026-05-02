package com.turkcell.library_cqrs_app.application.features.book.query.getall;

import java.util.List;
import java.util.UUID;

public record GetAllBookResponse(
        UUID id,
        String isbn,
        String title,
        int stock,
        int publishYear,
        String categoryName,
        List<String> authorNames) {
}
