package com.turkcell.library_cqrs_app.application.features.author.query.getall;

import java.util.UUID;

public record GetAllAuthorResponse(
                UUID id,
                String firstName,
                String lastName) {

}
