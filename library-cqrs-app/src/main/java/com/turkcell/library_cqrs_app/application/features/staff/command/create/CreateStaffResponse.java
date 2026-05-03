package com.turkcell.library_cqrs_app.application.features.staff.command.create;

import java.util.UUID;

public record CreateStaffResponse(
    UUID id,
    String firstName,
    String lastName,
    String role
) {}
