package com.turkcell.controller;

import com.turkcell.dto.book.*;
import com.turkcell.service.BookServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookServiceImpl bookService;

    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public CreatedBookResponse create(@RequestBody CreateBookRequest request) {
        return this.bookService.create(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBookResponse getById(@PathVariable UUID id) {
        return this.bookService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedBookResponse update(@PathVariable UUID id, @RequestBody UpdateBookRequest request) {
        return this.bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.bookService.delete(id);
    }
}