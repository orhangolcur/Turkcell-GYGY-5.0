package com.turkcell.spring_cqrs.application.features.category.command.create;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;

// Command-Query -> DTO
// record'larda constructor, getter, equals, hashcode gibi metotlar otomatik olarak oluşturulur
public record CreateCategoryCommand(String name) implements Command<CreatedCategoryResponse> {}
