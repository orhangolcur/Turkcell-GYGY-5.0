package com.turkcell.library_cqrs_app.application.features.author.command.create;

import java.util.UUID;

public record CreateAuthorResponse(
                UUID id,
                String firstName,
                String lastName) {

}
