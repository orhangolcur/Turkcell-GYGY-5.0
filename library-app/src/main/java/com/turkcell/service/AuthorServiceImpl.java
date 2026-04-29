package com.turkcell.service;

import com.turkcell.dto.author.*;
import com.turkcell.entity.Author;
import com.turkcell.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public CreatedAuthorResponse create(CreateAuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        this.authorRepository.save(author);

        CreatedAuthorResponse response = new CreatedAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        return response;
    }

    public List<ListAuthorResponse> getAll() {
        return this.authorRepository.findAll().stream().map(author -> {
            ListAuthorResponse response = new ListAuthorResponse();
            response.setId(author.getId());
            response.setFirstName(author.getFirstName());
            response.setLastName(author.getLastName());
            return response;
        }).toList();
    }

    public GetByIdAuthorResponse getById(UUID id) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found: " + id));

        GetByIdAuthorResponse response = new GetByIdAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setBookTitles(author.getBooks().stream()
                .map(book -> book.getTitle())
                .toList());
        return response;
    }

    public UpdatedAuthorResponse update(UUID id, UpdateAuthorRequest request) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found: " + id));

        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        this.authorRepository.save(author);

        UpdatedAuthorResponse response = new UpdatedAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        return response;
    }

    public void delete(UUID id) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found: " + id));
        this.authorRepository.delete(author);
    }
}