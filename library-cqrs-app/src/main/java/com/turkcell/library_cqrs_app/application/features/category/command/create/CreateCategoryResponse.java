package com.turkcell.library_cqrs_app.application.features.category.command.create;

import java.util.UUID;

public record CreateCategoryResponse(
        UUID id,
        String name,
        String description) {

}
