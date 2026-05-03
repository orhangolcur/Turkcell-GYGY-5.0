package com.turkcell.library_cqrs_app.application.features.staff.command.delete;

import java.util.UUID;

public record DeleteStaffResponse(
    UUID id,
    String message
) { }