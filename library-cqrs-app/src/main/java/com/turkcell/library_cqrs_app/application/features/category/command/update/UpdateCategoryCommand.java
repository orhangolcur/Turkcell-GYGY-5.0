package com.turkcell.library_cqrs_app.application.features.category.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record UpdateCategoryCommand(
        UUID id,
        String name,
        String description) implements Command<UpdateCategoryResponse> {

}
