package com.turkcell.library_cqrs_app.application.features.author.command.update;

import java.util.UUID;

public record UpdateAuthorResponse(
        UUID id,
        String firstName,
        String lastName) {

}
