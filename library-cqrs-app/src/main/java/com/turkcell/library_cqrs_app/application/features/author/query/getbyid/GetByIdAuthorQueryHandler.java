package com.turkcell.library_cqrs_app.application.features.author.query.getbyid;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.AuthorRepository;

@Component
public class GetByIdAuthorQueryHandler implements QueryHandler<GetByIdAuthorQuery, GetByIdAuthorResponse> {

    private final AuthorRepository repository;

    public GetByIdAuthorQueryHandler(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetByIdAuthorResponse handle(GetByIdAuthorQuery query) {
        return repository.findById(query.id())
                .map(author -> new GetByIdAuthorResponse(
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName()))
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + query.id()));
    }

}
