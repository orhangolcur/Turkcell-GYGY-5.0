package com.turkcell.library_cqrs_app.application.features.book.query.getall;

import java.util.List;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetAllBookQuery() implements Query<List<GetAllBookResponse>> {
}
