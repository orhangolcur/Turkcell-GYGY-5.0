package com.turkcell.controller;

import com.turkcell.dto.bookcopy.*;
import com.turkcell.service.BookCopyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book-copies")
public class BookCopiesController {
    private final BookCopyServiceImpl bookCopyService;

    public BookCopiesController(BookCopyServiceImpl bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @PostMapping
    public CreatedBookCopyResponse create(@RequestBody CreateBookCopyRequest request) {
        return this.bookCopyService.create(request);
    }

    @GetMapping
    public List<ListBookCopyResponse> getAll() {
        return this.bookCopyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBookCopyResponse getById(@PathVariable UUID id) {
        return this.bookCopyService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedBookCopyResponse update(@PathVariable UUID id, @RequestBody UpdateBookCopyRequest request) {
        return this.bookCopyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.bookCopyService.delete(id);
    }
}