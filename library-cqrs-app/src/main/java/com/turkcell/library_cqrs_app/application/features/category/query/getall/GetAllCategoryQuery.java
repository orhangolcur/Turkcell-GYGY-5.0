package com.turkcell.library_cqrs_app.application.features.category.query.getall;

import java.util.List;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetAllCategoryQuery() implements Query<List<GetAllCategoryResponse>> {

}
