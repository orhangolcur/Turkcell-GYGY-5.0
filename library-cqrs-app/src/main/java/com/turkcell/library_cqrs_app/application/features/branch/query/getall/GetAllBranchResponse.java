package com.turkcell.library_cqrs_app.application.features.branch.query.getall;

import java.util.UUID;

public record GetAllBranchResponse(
    UUID id,
    String name,
    String address,
    String phone
) {}
