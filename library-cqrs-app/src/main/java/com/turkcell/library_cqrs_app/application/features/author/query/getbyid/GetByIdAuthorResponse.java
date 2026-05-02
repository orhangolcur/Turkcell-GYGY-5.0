package com.turkcell.library_cqrs_app.application.features.author.query.getbyid;

import java.util.UUID;

public record GetByIdAuthorResponse(
        UUID id,
        String firstName,
        String lastName) {

}
