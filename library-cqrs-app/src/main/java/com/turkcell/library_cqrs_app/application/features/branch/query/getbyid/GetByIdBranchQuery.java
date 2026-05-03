package com.turkcell.library_cqrs_app.application.features.branch.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetByIdBranchQuery(UUID id) implements Query<GetByIdBranchResponse>{}
