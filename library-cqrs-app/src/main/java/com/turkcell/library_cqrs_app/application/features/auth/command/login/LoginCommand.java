package com.turkcell.library_cqrs_app.application.features.auth.command.login;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record LoginCommand(
        String email,
        String password) implements Command<LoginResponse> {

}
