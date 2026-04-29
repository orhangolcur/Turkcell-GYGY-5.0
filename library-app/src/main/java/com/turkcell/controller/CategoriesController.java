package com.turkcell.controller;

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
import com.turkcell.dto.category.CreateCategoryRequest;
import com.turkcell.dto.category.CreatedCategoryResponse;
import com.turkcell.dto.category.GetByIdCategoryResponse;
import com.turkcell.dto.category.ListCategoryResponse;
import com.turkcell.dto.category.UpdateCategoryRequest;
import com.turkcell.dto.category.UpdatedCategoryResponse;
import com.turkcell.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryServiceImpl categoryService;

    public CategoriesController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<ListCategoryResponse> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping
    public CreatedCategoryResponse create(@RequestBody CreateCategoryRequest request) {
        return this.categoryService.create(request);
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable UUID id) {
        return this.categoryService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCategoryResponse update(@PathVariable UUID id, @RequestBody UpdateCategoryRequest request) {
        return this.categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.categoryService.delete(id);
    }
}
