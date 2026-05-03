package com.turkcell.library_cqrs_app.application.features.branch.command.create;

import java.util.UUID;

public record CreateBranchResponse(
    UUID id,
    String name,
    String address,
    String phone
) {

}
