package com.turkcell.library_cqrs_app.application.features.staff.command.create;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStaffCommand(
    @NotBlank(message = "Ad boş olamaz")
    @Size(max = 100, message = "Ad en fazla 100 karakter olabilir")
    String firstName,

    @NotBlank(message = "Soyad boş olamaz")
    @Size(max = 100, message = "Soyad en fazla 100 karakter olabilir")
    String lastName,

    @NotBlank(message = "Rol boş olamaz")
    @Size(max = 50, message = "Rol en fazla 50 karakter olabilir")
    String role
) implements Command<CreateStaffResponse> { }
