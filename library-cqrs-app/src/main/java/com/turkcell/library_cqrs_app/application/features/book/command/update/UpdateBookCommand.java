package com.turkcell.library_cqrs_app.application.features.book.command.update;

import java.util.List;
import java.util.UUID;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.Command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateBookCommand(
        UUID id,

        @NotBlank(message = "Başlık boş olamaz")
        @Size(min = 2 , max = 100, message = "Başlık 2 ile 100 karakter arasında olmalıdır")
        String title,

        @NotBlank(message = "ISBN boş olamaz")
        @Size(min = 5 , max = 20, message = "ISBN 5 ile 20 karakter arasında olmalıdır")
        String isbn,
        
        @Min(value = 0, message = "Stok negatif olamaz")
        int stock,
        
        @Min(value = 1000, message = "Yayın yılı geçersiz")
        @Max(value = 2100, message = "Yayın yılı geçersiz")
        int publishYear,

        @NotNull(message = "Kategori boş olamaz")
        UUID categoryId,

        @NotNull(message = "En az bir yazar seçilmelidir")
        List<UUID> authorIds) implements Command<UpdateBookResponse> {
}
