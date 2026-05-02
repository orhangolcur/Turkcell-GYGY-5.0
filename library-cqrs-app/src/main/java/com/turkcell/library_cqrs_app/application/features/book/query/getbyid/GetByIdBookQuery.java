package com.turkcell.library_cqrs_app.application.features.book.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetByIdBookQuery(UUID id) implements Query<GetByIdBookResponse> {

}
