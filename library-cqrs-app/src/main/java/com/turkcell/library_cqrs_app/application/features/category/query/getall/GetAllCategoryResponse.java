package com.turkcell.library_cqrs_app.application.features.category.query.getall;

import java.util.UUID;

public record GetAllCategoryResponse(
        UUID id,
        String name,
        String description) {

}
