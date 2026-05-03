package com.turkcell.library_cqrs_app.application.features.staff.command.delete;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;
import java.util.UUID;

public record DeleteStaffCommand(UUID id) implements Command<DeleteStaffResponse> { }