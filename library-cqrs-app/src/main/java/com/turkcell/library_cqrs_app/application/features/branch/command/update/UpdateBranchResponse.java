package com.turkcell.library_cqrs_app.application.features.branch.command.update;

import java.util.UUID;

public record UpdateBranchResponse(
    UUID id,
    String name,
    String address,
    String phone
) {}
