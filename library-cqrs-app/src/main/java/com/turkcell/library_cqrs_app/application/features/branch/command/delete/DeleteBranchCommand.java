package com.turkcell.library_cqrs_app.application.features.branch.command.delete;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record DeleteBranchCommand(UUID id) implements Command<DeleteBranchResponse>{}
