package com.turkcell.library_cqrs_app.application.features.category.command.delete;

import java.util.UUID;

public record DeleteCategoryResponse(
        UUID id,
        String message) {

}
