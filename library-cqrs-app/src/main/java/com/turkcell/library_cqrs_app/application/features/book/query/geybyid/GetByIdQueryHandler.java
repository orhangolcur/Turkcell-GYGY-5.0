package com.turkcell.library_cqrs_app.application.features.book.query.geybyid;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class GetByIdQueryHandler implements QueryHandler<GetByIdBookQuery, GetByIdBookResponse> {

    private final BookRepository bookRepository;

    public GetByIdQueryHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public GetByIdBookResponse handle(GetByIdBookQuery query) {
        return bookRepository.findById(query.id())
                .map(book -> new GetByIdBookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getIsbn(),
                        book.getStock(),
                        book.getPublishYear()))
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + query.id()));
    }

}
