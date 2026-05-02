package com.turkcell.library_cqrs_app.application.features.author.query.getall;

import java.util.List;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetAllAuthorQuery() implements Query<List<GetAllAuthorResponse>> {

}
