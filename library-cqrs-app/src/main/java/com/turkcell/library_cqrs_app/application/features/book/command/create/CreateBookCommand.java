package com.turkcell.library_cqrs_app.application.features.book.command.create;

import java.util.List;
import java.util.UUID;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record CreateBookCommand(
        String isbn,
        String title,
        int stock,
        int publishYear,
        UUID categoryId,
        List<UUID> authorIds) implements Command<CreateBookResponse> {
}
