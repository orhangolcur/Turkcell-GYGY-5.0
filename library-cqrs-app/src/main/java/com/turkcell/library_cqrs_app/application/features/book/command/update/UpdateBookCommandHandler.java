package com.turkcell.library_cqrs_app.application.features.book.command.update;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class UpdateBookCommandHandler implements CommandHandler<UpdateBookCommand, UpdateBookResponse> {

    private final BookRepository bookRepository;

    public UpdateBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public UpdateBookResponse handle(UpdateBookCommand command) {
        var book = bookRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(command.title());
        book.setIsbn(command.isbn());
        book.setStock(command.stock());
        book.setPublishYear(command.publishYear());

        bookRepository.save(book);

        return new UpdateBookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getStock(),
                book.getPublishYear());
    }
}
