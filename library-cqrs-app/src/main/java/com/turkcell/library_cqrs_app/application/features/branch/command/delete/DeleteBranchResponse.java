package com.turkcell.library_cqrs_app.application.features.branch.command.delete;

import java.util.UUID;

public record DeleteBranchResponse(
    UUID id,
    String message
) {}
