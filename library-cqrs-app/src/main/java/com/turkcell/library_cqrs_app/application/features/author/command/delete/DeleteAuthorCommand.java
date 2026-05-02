package com.turkcell.library_cqrs_app.application.features.author.command.delete;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record DeleteAuthorCommand(UUID id) implements Command<DeleteAuthorResponse> {

}
