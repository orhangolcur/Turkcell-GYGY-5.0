package com.turkcell.library_cqrs_app.application.features.book.command.create;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record CreateBookCommand(
        String isbn,
        String title,
        int stock,
        int publishYear) implements Command<CreateBookResponse> {
}
