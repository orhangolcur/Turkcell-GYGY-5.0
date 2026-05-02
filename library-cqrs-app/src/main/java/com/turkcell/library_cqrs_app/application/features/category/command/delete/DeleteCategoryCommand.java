package com.turkcell.library_cqrs_app.application.features.category.command.delete;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record DeleteCategoryCommand(UUID id) implements Command<DeleteCategoryResponse> {

}
