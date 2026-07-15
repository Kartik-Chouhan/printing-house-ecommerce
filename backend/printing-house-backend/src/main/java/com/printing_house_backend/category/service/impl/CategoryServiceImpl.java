package com.printing_house_backend.category.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.printing_house_backend.category.dto.CategoryRequest;
import com.printing_house_backend.category.dto.CategoryResponse;
import com.printing_house_backend.category.entity.Category;
import com.printing_house_backend.category.mapper.CategoryMapper;
import com.printing_house_backend.category.repository.CategoryRepository;
import com.printing_house_backend.category.service.CategoryService;
import com.printing_house_backend.exception.DuplicateResourceException;
import com.printing_house_backend.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryRequest request) {
        if (categoryRepository.existsByCategoryNameAndIsActiveTrue(request.categoryName())) {
            throw new DuplicateResourceException("Category '" + request.categoryName() + "' already exists.");
        }

        Category category = categoryMapper.toEntity(request);

        if (category.getIsActive() == null) {
            category.setIsActive(true);
        }

        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    public CategoryResponse getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category with ID: " + categoryId + "' doesn't exists."));

        if (!Boolean.TRUE.equals(category.getIsActive())) {
            throw new ResourceNotFoundException("Category with ID: " + categoryId + "' doesn't exists.");
        }

        return categoryMapper.toResponse(category);

    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAllByIsActiveTrueOrderByDisplayOrderAsc();
        return categoryMapper.toResponseList(categories);
    }

    @Override
    public CategoryResponse updateCategory(Long categoryId, CategoryRequest request) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category with ID: "+categoryId+" doesn't exists"));
        if(!Boolean.TRUE.equals(category.getIsActive())){
           throw new ResourceNotFoundException("Category with ID: "+categoryId+" doesn't exists");
        }

        if(categoryRepository.existsByCategoryNameAndCategoryIdNotAndIsActiveTrue(request.categoryName(), categoryId)){
            throw new DuplicateResourceException("Category with ID: "+categoryId+" already exists");
        }

        category.setCategoryName(request.categoryName());
        category.setDescription(request.description());
        category.setImageUrl(request.imageUrl());
        category.setDisplayOrder(category.getDisplayOrder());
        // category.setUpdatedAt(category.getUpdatedAt());

        Category updateCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(updateCategory);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with ID: "+categoryId+" doesn't exists"));
        
        if(!Boolean.TRUE.equals(category.getIsActive())){
            throw new ResourceNotFoundException("Category with ID: "+categoryId+" doesn't exists");
        }

        category.setIsActive(false);
        categoryRepository.save(category);
    }
}
