package com.turkcell.library_cqrs_app.application.features.author.command.update;

import java.util.UUID;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record UpdateAuthorCommand(
        UUID id,
        String firstName,
        String lastName) implements Command<UpdateAuthorResponse> {

}
