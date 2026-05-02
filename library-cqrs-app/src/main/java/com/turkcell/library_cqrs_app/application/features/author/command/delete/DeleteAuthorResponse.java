package com.turkcell.library_cqrs_app.application.features.author.command.delete;

import java.util.UUID;

public record DeleteAuthorResponse(
                UUID id,
                String message) {

}
