package com.turkcell.library_cqrs_app.application.features.auth.command.login;

import java.util.UUID;

public record LoginResponse(
        UUID id,
        String email,
        String message) {

}
