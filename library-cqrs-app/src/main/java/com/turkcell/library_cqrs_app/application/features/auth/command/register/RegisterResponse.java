package com.turkcell.library_cqrs_app.application.features.auth.command.register;

import java.util.UUID;

public record RegisterResponse(UUID id, String email) {

}
