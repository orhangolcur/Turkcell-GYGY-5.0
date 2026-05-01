package com.turkcell.library_cqrs_app.application.features.book.query.getall;

import java.util.List;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.BookRepository;

@Component
public class GetAllBookQueryHandler implements QueryHandler<GetAllBookQuery, List<GetAllBookResponse>> {

    private final BookRepository bookRepository;

    public GetAllBookQueryHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<GetAllBookResponse> handle(GetAllBookQuery query) {
        return bookRepository.findAll().stream()
                .map(book -> new GetAllBookResponse(
                        book.getId(),
                        book.getIsbn(),
                        book.getTitle(),
                        book.getStock(),
                        book.getPublishYear()))
                .toList();
    }

}
