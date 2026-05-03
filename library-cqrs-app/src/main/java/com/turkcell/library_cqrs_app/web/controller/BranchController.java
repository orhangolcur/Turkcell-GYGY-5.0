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
import com.turkcell.library_cqrs_app.application.features.branch.command.create.CreateBranchCommand;
import com.turkcell.library_cqrs_app.application.features.branch.command.create.CreateBranchResponse;
import com.turkcell.library_cqrs_app.application.features.branch.command.delete.DeleteBranchCommand;
import com.turkcell.library_cqrs_app.application.features.branch.command.delete.DeleteBranchResponse;
import com.turkcell.library_cqrs_app.application.features.branch.command.update.UpdateBranchCommand;
import com.turkcell.library_cqrs_app.application.features.branch.command.update.UpdateBranchResponse;
import com.turkcell.library_cqrs_app.application.features.branch.query.getall.GetAllBranchQuery;
import com.turkcell.library_cqrs_app.application.features.branch.query.getall.GetAllBranchResponse;
import com.turkcell.library_cqrs_app.application.features.branch.query.getbyid.GetByIdBranchQuery;
import com.turkcell.library_cqrs_app.application.features.branch.query.getbyid.GetByIdBranchResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/branches")
public class BranchController {

    private final Mediator mediator;

    public BranchController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public List<GetAllBranchResponse> getAll() {
        return mediator.send(new GetAllBranchQuery());
    }

    @GetMapping("/{id}")
    public GetByIdBranchResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdBranchQuery(id));
    }

    @PostMapping
    public CreateBranchResponse create(@RequestBody @Valid CreateBranchCommand command) {
        return mediator.send(command);
    }

    @PutMapping("/{id}")
    public UpdateBranchResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateBranchCommand command) {
        return mediator.send(new UpdateBranchCommand(
            id,
            command.name(),
            command.address(),
            command.phone()
        ));
    }

    @DeleteMapping("/{id}")
    public DeleteBranchResponse delete(@PathVariable UUID id) {
        return mediator.send(new DeleteBranchCommand(id));
    }
}
