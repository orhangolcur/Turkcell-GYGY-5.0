package com.turkcell.library_cqrs_app.application.features.book.command.update;

import java.util.UUID;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record UpdateBookCommand(
        UUID id,
        String title,
        String isbn,
        int stock,
        int publishYear) implements Command<UpdateBookResponse> {
}
