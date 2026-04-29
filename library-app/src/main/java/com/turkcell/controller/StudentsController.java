package com.turkcell.controller;

import com.turkcell.dto.student.*;
import com.turkcell.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentServiceImpl studentService;

    public StudentsController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public CreatedStudentResponse create(@RequestBody CreateStudentRequest request) {
        return this.studentService.create(request);
    }

    @GetMapping
    public List<ListStudentResponse> getAll() {
        return this.studentService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdStudentResponse getById(@PathVariable UUID id) {
        return this.studentService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedStudentResponse update(@PathVariable UUID id, @RequestBody UpdateStudentRequest request) {
        return this.studentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.studentService.delete(id);
    }
}