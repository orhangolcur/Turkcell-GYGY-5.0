package com.turkcell.library_cqrs_app.application.features.category.query.getbyid;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs_app.core.exception.NotFoundException;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.CategoryRepository;

@Component
public class GetByIdCategoryQueryHandler implements QueryHandler<GetByIdCategoryQuery, GetByIdCategoryResponse> {

    private final CategoryRepository categoryRepository;

    public GetByIdCategoryQueryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GetByIdCategoryResponse handle(GetByIdCategoryQuery query) {
        var category = categoryRepository.findById(query.id())
                .orElseThrow(() -> new NotFoundException("Kategori bulunamadı"));

        return new GetByIdCategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription());
    }

}
