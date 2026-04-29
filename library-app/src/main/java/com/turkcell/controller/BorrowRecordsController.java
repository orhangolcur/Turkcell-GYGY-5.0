package com.turkcell.controller;

import com.turkcell.dto.borrowrecord.*;
import com.turkcell.service.BorrowRecordServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordsController {
    private final BorrowRecordServiceImpl borrowRecordService;

    public BorrowRecordsController(BorrowRecordServiceImpl borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping
    public CreatedBorrowRecordResponse create(@RequestBody CreateBorrowRecordRequest request) {
        return this.borrowRecordService.create(request);
    }

    @GetMapping
    public List<ListBorrowRecordResponse> getAll() {
        return this.borrowRecordService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBorrowRecordResponse getById(@PathVariable UUID id) {
        return this.borrowRecordService.getById(id);
    }
}