package com.turkcell.library_cqrs_app.application.features.staff.query.getall;

import java.util.UUID;

public record GetAllStaffResponse(
    UUID id,
    String firstName,
    String lastName,
    String role
) { }
