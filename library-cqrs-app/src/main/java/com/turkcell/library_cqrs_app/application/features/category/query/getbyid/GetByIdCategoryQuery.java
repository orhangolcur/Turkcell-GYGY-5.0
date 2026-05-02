package com.turkcell.library_cqrs_app.application.features.category.query.getbyid;

import java.util.UUID;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetByIdCategoryQuery(UUID id) implements Query<GetByIdCategoryResponse> {

}
