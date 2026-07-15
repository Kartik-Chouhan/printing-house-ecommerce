package com.printing_house_backend.category.service;
import com.printing_house_backend.category.dto.*;

import java.util.*;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse getCategoryById(Long categoryId);

    List<CategoryResponse> getAllCategories();

    CategoryResponse updateCategory(Long categoryId, CategoryRequest request);

    void deleteCategoryById(Long categoryId);
}
