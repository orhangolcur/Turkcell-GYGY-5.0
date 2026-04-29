package com.turkcell.spring_cqrs.application.features.category.command.create;

import java.util.UUID;

import com.turkcell.spring_cqrs.core.mediator.cqrs.CommandHandler;

public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, UUID>
{

    @Override
    public UUID handle(CreateCategoryCommand command) {
        System.out.println("Create Command Handler çalıştı");
        return UUID.randomUUID();
    }

}
