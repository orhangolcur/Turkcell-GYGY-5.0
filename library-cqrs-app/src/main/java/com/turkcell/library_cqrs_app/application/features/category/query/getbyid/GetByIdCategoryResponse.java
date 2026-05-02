package com.turkcell.library_cqrs_app.application.features.category.query.getbyid;

import java.util.UUID;

public record GetByIdCategoryResponse(
        UUID id,
        String name,
        String description) {

}
