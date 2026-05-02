package com.turkcell.library_cqrs_app.application.features.auth.command.register;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record RegisterCommand(
        String email,
        String password) implements Command<RegisterResponse> {

}
