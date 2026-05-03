package com.turkcell.library_cqrs_app.application.features.staff.command.update;

import java.util.UUID;

public record UpdateStaffResponse(
    UUID id,
    String firstName,
    String lastName,
    String role
) { }