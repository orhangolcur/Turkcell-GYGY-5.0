package com.turkcell.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.dto.category.CreateCategoryRequest;
import com.turkcell.dto.category.CreatedCategoryResponse;
import com.turkcell.dto.category.GetByIdCategoryResponse;
import com.turkcell.dto.category.ListCategoryResponse;
import com.turkcell.dto.category.UpdateCategoryRequest;
import com.turkcell.dto.category.UpdatedCategoryResponse;
import com.turkcell.entity.Category;
import com.turkcell.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreatedCategoryResponse create(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        this.categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public List<ListCategoryResponse> getAll() {
        return this.categoryRepository.findAll().stream().map(category -> {
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            return response;
        }).toList();
    }

    public GetByIdCategoryResponse getById(UUID id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        
        GetByIdCategoryResponse response = new GetByIdCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setBookTitles(category.getBooks().stream().map(book -> book.getTitle()).toList());

        return response;
    } 

    public UpdatedCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        this.categoryRepository.save(category);

        UpdatedCategoryResponse response = new UpdatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }

    public void delete(UUID id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        
        this.categoryRepository.delete(category);
    }
}   
