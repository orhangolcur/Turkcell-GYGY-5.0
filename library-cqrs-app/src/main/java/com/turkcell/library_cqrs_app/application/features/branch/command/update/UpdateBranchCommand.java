package com.turkcell.library_cqrs_app.application.features.branch.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateBranchCommand(
    UUID id,

    @NotBlank(message = "Şube adı boş olamaz")
    @Size(max = 100, message = "Şube adı en fazla 100 karakter olabilir")
    String name,

    @Size(max = 200, message = "Adres en fazla 200 karakter olabilir")
    String address,

    @Size(max = 20, message = "Telefon numarası en fazla 20 karakter olabilir")
    String phone

) implements Command<UpdateBranchResponse> {}
