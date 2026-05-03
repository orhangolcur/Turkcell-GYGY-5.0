package com.turkcell.library_cqrs_app.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.turkcell.library_cqrs_app.application.features.book.command.create.CreateBookCommand;
import com.turkcell.library_cqrs_app.application.features.book.command.create.CreateBookResponse;
import com.turkcell.library_cqrs_app.application.features.book.command.delete.DeleteBookCommand;
import com.turkcell.library_cqrs_app.application.features.book.command.delete.DeleteBookResponse;
import com.turkcell.library_cqrs_app.application.features.book.command.update.UpdateBookCommand;
import com.turkcell.library_cqrs_app.application.features.book.command.update.UpdateBookResponse;
import com.turkcell.library_cqrs_app.application.features.book.query.getall.GetAllBookQuery;
import com.turkcell.library_cqrs_app.application.features.book.query.getall.GetAllBookResponse;
import com.turkcell.library_cqrs_app.application.features.book.query.getbyid.GetByIdBookQuery;
import com.turkcell.library_cqrs_app.application.features.book.query.getbyid.GetByIdBookResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Mediator mediator;

    public BookController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreateBookResponse create(@RequestBody @Valid CreateBookCommand command) {
        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllBookResponse> getAll() {
        return mediator.send(new GetAllBookQuery());
    }

    @GetMapping("/{id}")
    public GetByIdBookResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdBookQuery(id));
    }

    @PutMapping("/{id}")
    public UpdateBookResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateBookCommand command) {
        return mediator.send(new UpdateBookCommand(
                id,
                command.title(),
                command.isbn(),
                command.stock(),
                command.publishYear(),
                command.categoryId(),
                command.authorIds()));
    }

    @DeleteMapping("/{id}")
    public DeleteBookResponse delete(@PathVariable UUID id) {
        return mediator.send(new DeleteBookCommand(id));
    }
}
