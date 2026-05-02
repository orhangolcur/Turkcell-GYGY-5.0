package com.turkcell.library_cqrs_app.application.features.category;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.domain.entity.Category;
import com.turkcell.library_cqrs_app.persistence.repository.CategoryRepository;

@Component
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getByIdOrThrow(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı: " + id));
    }

    public void categoryNameMustBeUnique(String name) {
        if (categoryRepository.existsByName(name)) {
            throw new RuntimeException("Bu isimde bir kategori zaten mevcut: " + name);
        }
    }

    public void categoryNameMustBeUniqueForUpdate(UUID id, String name) {
        categoryRepository.findById(id).ifPresent(category -> {
            if (!category.getName().equals(name) && categoryRepository.existsByName(name)) {
                throw new RuntimeException("Bu isimde bir kategori zaten mevcut: " + name);
            }
        });
    }

    public void categoryMustExist(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Kategori bulunamadı: " + id);
        }
    }
}
