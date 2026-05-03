package com.turkcell.library_cqrs_app.application.features.branch.query.getbyid;

import java.util.UUID;

public record GetByIdBranchResponse(
    UUID id,
    String name,
    String address,
    String phone
) {}
