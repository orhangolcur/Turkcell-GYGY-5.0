package com.turkcell.library_cqrs_app.application.features.staff.query.getbyid;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Query;
import java.util.UUID;

public record GetByIdStaffQuery(UUID id) implements Query<GetByIdStaffResponse> { }
