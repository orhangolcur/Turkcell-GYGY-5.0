package com.turkcell.library_cqrs_app.application.features.book.command.delete;

import java.util.UUID;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record DeleteBookCommand(UUID id) implements Command<DeleteBookResponse> {

}
