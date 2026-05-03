package com.turkcell.library_cqrs_app.application.features.branch.query.getall;

import java.util.List;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;

public record GetAllBranchQuery() implements Query<List<GetAllBranchResponse>> {}
