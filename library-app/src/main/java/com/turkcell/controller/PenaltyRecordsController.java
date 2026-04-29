package com.turkcell.controller;

import com.turkcell.dto.penaltyrecord.*;
import com.turkcell.service.PenaltyRecordServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/penalty-records")
public class PenaltyRecordsController {
    private final PenaltyRecordServiceImpl penaltyRecordService;

    public PenaltyRecordsController(PenaltyRecordServiceImpl penaltyRecordService) {
        this.penaltyRecordService = penaltyRecordService;
    }

    @PostMapping
    public CreatedPenaltyRecordResponse create(@RequestBody CreatePenaltyRecordRequest request) {
        return this.penaltyRecordService.create(request);
    }

    @GetMapping
    public List<ListPenaltyRecordResponse> getAll() {
        return this.penaltyRecordService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdPenaltyRecordResponse getById(@PathVariable UUID id) {
        return this.penaltyRecordService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedPenaltyRecordResponse update(@PathVariable UUID id, @RequestBody UpdatePenaltyRecordRequest request) {
        return this.penaltyRecordService.update(id, request);
    }
}