package com.turkcell.library_cqrs_app.application.features.category.command.update;

import java.util.UUID;

public record UpdateCategoryResponse(
        UUID id,
        String name,
        String description) {

}
