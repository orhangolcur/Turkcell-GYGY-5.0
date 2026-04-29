package com.turkcell.controller;

import com.turkcell.dto.staff.*;
import com.turkcell.service.StaffServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffServiceImpl staffService;

    public StaffController(StaffServiceImpl staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public CreatedStaffResponse create(@RequestBody CreateStaffRequest request) {
        return this.staffService.create(request);
    }

    @GetMapping
    public List<ListStaffResponse> getAll() {
        return this.staffService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdStaffResponse getById(@PathVariable UUID id) {
        return this.staffService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedStaffResponse update(@PathVariable UUID id, @RequestBody UpdateStaffRequest request) {
        return this.staffService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.staffService.delete(id);
    }
}