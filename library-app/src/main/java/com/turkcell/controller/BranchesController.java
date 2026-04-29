package com.turkcell.controller;

import com.turkcell.dto.branch.*;
import com.turkcell.service.BranchServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
public class BranchesController {
    private final BranchServiceImpl branchService;

    public BranchesController(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public CreatedBranchResponse create(@RequestBody CreateBranchRequest request) {
        return this.branchService.create(request);
    }

    @GetMapping
    public List<ListBranchResponse> getAll() {
        return this.branchService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBranchResponse getById(@PathVariable UUID id) {
        return this.branchService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedBranchResponse update(@PathVariable UUID id, @RequestBody UpdateBranchRequest request) {
        return this.branchService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.branchService.delete(id);
    }
}