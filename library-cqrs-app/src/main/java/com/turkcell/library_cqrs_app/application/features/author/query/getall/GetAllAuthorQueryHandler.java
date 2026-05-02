package com.turkcell.library_cqrs_app.application.features.author.query.getall;

import java.util.List;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.AuthorRepository;

@Component
public class GetAllAuthorQueryHandler implements QueryHandler<GetAllAuthorQuery, List<GetAllAuthorResponse>> {

    private final AuthorRepository repository;

    public GetAllAuthorQueryHandler(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetAllAuthorResponse> handle(GetAllAuthorQuery query) {
        return repository.findAll().stream()
                .map(author -> new GetAllAuthorResponse(
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName()))
                .toList();
    }

}
