package com.turkcell.library_cqrs_app.application.features.author.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateAuthorCommand(
        UUID id,

        @NotBlank(message = "Ad boş olamaz")
        @Size(min = 2, max = 50, message = "Ad 2 ile 50 karakter arasında olmalıdır")
        String firstName,
        
        @NotBlank(message = "Soyad boş olamaz")
        @Size(min = 2, max = 50, message = "Soyad 2 ile 50 karakter arasında olmalıdır")
        String lastName) implements Command<UpdateAuthorResponse> {

}
