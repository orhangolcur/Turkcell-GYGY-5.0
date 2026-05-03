package com.turkcell.library_cqrs_app.application.features.category.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCategoryCommand(
        UUID id,

        @NotBlank(message = "Kategori adı boş olamaz")
        @Size(min = 2, max = 100, message = "Kategori adı 2 ile 100 karakter arasında olmalıdır")
        String name,

        @Size(max = 255, message = "Açıklama 255 karakterden fazla olamaz")
        String description) implements Command<UpdateCategoryResponse> {

}
