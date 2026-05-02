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

import com.turkcell.library_cqrs_app.application.features.book.query.getbyid.GetByIdBookResponse;
import com.turkcell.library_cqrs_app.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs_app.application.features.category.command.create.CreateCategoryResponse;
import com.turkcell.library_cqrs_app.application.features.category.command.delete.DeleteCategoryCommand;
import com.turkcell.library_cqrs_app.application.features.category.command.delete.DeleteCategoryResponse;
import com.turkcell.library_cqrs_app.application.features.category.command.update.UpdateCategoryCommand;
import com.turkcell.library_cqrs_app.application.features.category.command.update.UpdateCategoryResponse;
import com.turkcell.library_cqrs_app.application.features.category.query.getall.GetAllCategoryQuery;
import com.turkcell.library_cqrs_app.application.features.category.query.getall.GetAllCategoryResponse;
import com.turkcell.library_cqrs_app.application.features.category.query.getbyid.GetByIdCategoryQuery;
import com.turkcell.library_cqrs_app.application.features.category.query.getbyid.GetByIdCategoryResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final Mediator mediator;

    public CategoryController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreateCategoryResponse create(@RequestBody CreateCategoryCommand command) {
        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllCategoryResponse> getAll() {
        return mediator.send(new GetAllCategoryQuery());
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdCategoryQuery(id));
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id, @RequestBody UpdateCategoryCommand command) {
        return mediator.send(new UpdateCategoryCommand(id, command.name(), command.description()));
    }

    @DeleteMapping("/{id}")
    public DeleteCategoryResponse delete(@PathVariable UUID id) {
        return mediator.send(new DeleteCategoryCommand(id));
    }
}
