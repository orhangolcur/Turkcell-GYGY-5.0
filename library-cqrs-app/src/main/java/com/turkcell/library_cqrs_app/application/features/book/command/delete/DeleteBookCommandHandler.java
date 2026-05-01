package com.turkcell.library_cqrs_app.application.features.book.command.delete;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class DeleteBookCommandHandler implements CommandHandler<DeleteBookCommand, DeleteBookResponse> {

    private final BookRepository bookRepository;

    public DeleteBookCommandHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public DeleteBookResponse handle(DeleteBookCommand command) {
        var book = bookRepository.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + command.id()));

        bookRepository.delete(book);

        return new DeleteBookResponse(
                command.id(),
                "Book with id " + command.id() + " has been deleted successfully.");
    }

}
