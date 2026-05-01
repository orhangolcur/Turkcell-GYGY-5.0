package com.turkcell.library_cqrs_app.application.features.book.command.create;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs_app.domain.entity.Book;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, CreateBookResponse> {
    private final BookRepository bookRepository;

    public CreateBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public CreateBookResponse handle(CreateBookCommand command) {

        if (bookRepository.existsByIsbn(command.isbn())) {
            throw new IllegalArgumentException("Bu ISBN zaten kayıtlı: " + command.isbn());
        }

        Book book = new Book();
        book.setIsbn(command.isbn());
        book.setTitle(command.title());
        book.setStock(command.stock());
        book.setPublishYear(command.publishYear());

        Book savedBook = bookRepository.save(book);

        return new CreateBookResponse(
                savedBook.getId(),
                savedBook.getIsbn(),
                savedBook.getTitle(),
                savedBook.getStock(),
                savedBook.getPublishYear());
    }

}
