package com.turkcell.spring_cqrs.application.features.category.command.create;

import org.hibernate.validator.constraints.Length;
import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;
import jakarta.validation.constraints.NotBlank;

// Command-Query -> DTO
// record'larda constructor, getter, equals, hashcode gibi metotlar otomatik olarak oluşturulur
public record CreateCategoryCommand(
    @NotBlank @Length(min=3,max=100) String name
    
) implements Command<CreatedCategoryResponse> {}
