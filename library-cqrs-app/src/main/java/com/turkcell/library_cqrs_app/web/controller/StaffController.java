package com.turkcell.library_cqrs_app.web.controller;

import com.turkcell.library_cqrs_app.application.features.staff.command.create.CreateStaffCommand;
import com.turkcell.library_cqrs_app.application.features.staff.command.create.CreateStaffResponse;
import com.turkcell.library_cqrs_app.application.features.staff.command.delete.DeleteStaffCommand;
import com.turkcell.library_cqrs_app.application.features.staff.command.delete.DeleteStaffResponse;
import com.turkcell.library_cqrs_app.application.features.staff.command.update.UpdateStaffCommand;
import com.turkcell.library_cqrs_app.application.features.staff.command.update.UpdateStaffResponse;
import com.turkcell.library_cqrs_app.application.features.staff.query.getall.GetAllStaffQuery;
import com.turkcell.library_cqrs_app.application.features.staff.query.getall.GetAllStaffResponse;
import com.turkcell.library_cqrs_app.application.features.staff.query.getbyid.GetByIdStaffQuery;
import com.turkcell.library_cqrs_app.application.features.staff.query.getbyid.GetByIdStaffResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final Mediator mediator;

    public StaffController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreateStaffResponse create(@RequestBody @Valid CreateStaffCommand command) {
        return mediator.send(command);
    }

    @PutMapping("/{id}")
    public UpdateStaffResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateStaffCommand command) {
        return mediator.send(new UpdateStaffCommand(id, command.firstName(), command.lastName(), command.role()));
    }

    @DeleteMapping("/{id}")
    public DeleteStaffResponse delete(@PathVariable UUID id) {
        return mediator.send(new DeleteStaffCommand(id));
    }

    @GetMapping
    public List<GetAllStaffResponse> getAll() {
        return mediator.send(new GetAllStaffQuery());
    }

    @GetMapping("/{id}")
    public GetByIdStaffResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdStaffQuery(id));
    }
}