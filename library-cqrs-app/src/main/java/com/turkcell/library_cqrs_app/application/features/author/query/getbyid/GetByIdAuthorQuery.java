package com.turkcell.library_cqrs_app.application.features.author.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetByIdAuthorQuery(UUID id) implements Query<GetByIdAuthorResponse> {

}
