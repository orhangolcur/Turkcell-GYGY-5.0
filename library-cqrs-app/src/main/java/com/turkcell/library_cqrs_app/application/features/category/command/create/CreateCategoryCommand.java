package com.turkcell.library_cqrs_app.application.features.category.command.create;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

public record CreateCategoryCommand(
        String name,
        String description) implements Command<CreateCategoryResponse> {

}
