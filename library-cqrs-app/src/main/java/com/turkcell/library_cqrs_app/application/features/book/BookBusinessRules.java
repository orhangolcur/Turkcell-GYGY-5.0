package com.turkcell.library_cqrs_app.application.features.book;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.domain.entity.Book;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class BookBusinessRules {

    private final BookRepository bookRepository;

    public BookBusinessRules(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void isbnMustBeUnique(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            throw new RuntimeException("Bu ISBN zaten kayıtlı: " + isbn);
        }
    }

    public void isbnMustBeUniqueForUpdate(UUID id, String isbn) {
        bookRepository.findById(id).ifPresent(book -> {
            if (!book.getIsbn().equals(isbn) && bookRepository.existsByIsbn(isbn)) {
                throw new RuntimeException("Bu ISBN zaten kayıtlı: " + isbn);
            }
        });
    }

    public void bookMustExist(UUID id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Kitap bulunamadı: " + id);
        }
    }

    public Book getByIdOrThrow(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı: " + id));
    }
}
