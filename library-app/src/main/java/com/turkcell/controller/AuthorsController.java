package com.turkcell.controller;

import com.turkcell.dto.author.*;
import com.turkcell.service.AuthorServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    private final AuthorServiceImpl authorService;

    public AuthorsController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public CreatedAuthorResponse create(@RequestBody CreateAuthorRequest request) {
        return this.authorService.create(request);
    }

    @GetMapping
    public List<ListAuthorResponse> getAll() {
        return this.authorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getById(@PathVariable UUID id) {
        return this.authorService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedAuthorResponse update(@PathVariable UUID id, @RequestBody UpdateAuthorRequest request) {
        return this.authorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.authorService.delete(id);
    }
}