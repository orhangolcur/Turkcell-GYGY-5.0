package com.turkcell.library_cqrs_app.application.features.auth.command.register;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterCommand(
        @NotBlank(message = "Email boş olamaz")
        @Email(message = "Geçerli bir email adresi giriniz")
        String email,

        @NotBlank(message = "Şifre boş olamaz")
        @Size(min = 6, max = 20, message = "Şifre 6 ile 20 karakter arasında olmalıdır")
        String password) implements Command<RegisterResponse> {

}
