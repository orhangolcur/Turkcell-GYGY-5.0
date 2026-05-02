package com.turkcell.library_cqrs_app.application.features.author.command.create;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record CreateAuthorCommand(
                String firstName,
                String lastName) implements Command<CreateAuthorResponse> {
}
