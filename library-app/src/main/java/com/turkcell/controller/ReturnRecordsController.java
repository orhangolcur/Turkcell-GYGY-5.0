package com.turkcell.controller;

import com.turkcell.dto.returnrecord.*;
import com.turkcell.service.ReturnRecordServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/return-records")
public class ReturnRecordsController {
    private final ReturnRecordServiceImpl returnRecordService;

    public ReturnRecordsController(ReturnRecordServiceImpl returnRecordService) {
        this.returnRecordService = returnRecordService;
    }

    @PostMapping
    public CreatedReturnRecordResponse create(@RequestBody CreateReturnRecordRequest request) {
        return this.returnRecordService.create(request);
    }

    @GetMapping
    public List<ListReturnRecordResponse> getAll() {
        return this.returnRecordService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdReturnRecordResponse getById(@PathVariable UUID id) {
        return this.returnRecordService.getById(id);
    }
}