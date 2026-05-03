package com.turkcell.library_cqrs_app.application.features.staff.query.getbyid;

import java.util.UUID;

public record GetByIdStaffResponse(
    UUID id,
    String firstName,
    String lastName,
    String role
) { }