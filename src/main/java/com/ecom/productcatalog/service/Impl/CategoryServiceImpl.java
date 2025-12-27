package com.ecom.productcatalog.service.Impl;

import com.ecom.productcatalog.dto.request.CategoryRequest;
import com.ecom.productcatalog.dto.response.CategoryResponse;
import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(this::changeToCategoryResponse)
                .toList();
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        return  changeToCategoryResponse(categoryRepository.save(changeToCategory(categoryRequest)));
    }

    private Category changeToCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }

    private CategoryResponse changeToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
