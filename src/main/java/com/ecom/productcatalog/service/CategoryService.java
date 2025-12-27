package com.ecom.productcatalog.service;

import com.ecom.productcatalog.dto.request.CategoryRequest;
import com.ecom.productcatalog.dto.response.CategoryResponse;
import com.ecom.productcatalog.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    CategoryResponse createCategory(CategoryRequest categoryRequest);
}
