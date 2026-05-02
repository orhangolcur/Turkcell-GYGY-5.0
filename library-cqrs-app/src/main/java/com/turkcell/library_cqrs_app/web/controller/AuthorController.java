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

import com.turkcell.library_cqrs_app.application.features.author.command.create.CreateAuthorCommand;
import com.turkcell.library_cqrs_app.application.features.author.command.create.CreateAuthorResponse;
import com.turkcell.library_cqrs_app.application.features.author.command.delete.DeleteAuthorCommand;
import com.turkcell.library_cqrs_app.application.features.author.command.delete.DeleteAuthorResponse;
import com.turkcell.library_cqrs_app.application.features.author.command.update.UpdateAuthorCommand;
import com.turkcell.library_cqrs_app.application.features.author.command.update.UpdateAuthorResponse;
import com.turkcell.library_cqrs_app.application.features.author.query.getall.GetAllAuthorQuery;
import com.turkcell.library_cqrs_app.application.features.author.query.getall.GetAllAuthorResponse;
import com.turkcell.library_cqrs_app.application.features.author.query.getbyid.GetByIdAuthorQuery;
import com.turkcell.library_cqrs_app.application.features.author.query.getbyid.GetByIdAuthorResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final Mediator mediator;

    public AuthorController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public List<GetAllAuthorResponse> getAll() {
        return mediator.send(new GetAllAuthorQuery());
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdAuthorQuery(id));
    }

    @PostMapping
    public CreateAuthorResponse create(@RequestBody CreateAuthorCommand command) {
        return mediator.send(command);
    }

    @PutMapping("/{id}")
    public UpdateAuthorResponse update(@PathVariable UUID id, @RequestBody UpdateAuthorCommand command) {
        return mediator.send(new UpdateAuthorCommand(id, command.firstName(), command.lastName()));
    }

    @DeleteMapping("/{id}")
    public DeleteAuthorResponse delete(@PathVariable UUID id) {
        return mediator.send(new DeleteAuthorCommand(id));
    }

}
