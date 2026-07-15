package com.printing_house_backend.category.controller;

import static com.printing_house_backend.common.constants.ApiEndpoints.CATEGORY;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import com.printing_house_backend.category.dto.CategoryRequest;
import com.printing_house_backend.category.dto.CategoryResponse;
import com.printing_house_backend.category.service.CategoryService;
import com.printing_house_backend.common.constants.ApiMessages;
import com.printing_house_backend.common.response.ApiResponse;
import com.printing_house_backend.common.response.ResponseBuilder;

@RestController
@RequestMapping(CATEGORY)
@RequiredArgsConstructor
@Tag(name = "Category APIs", description = "APIs for managing categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Create Category", description = "Creates a new active category.")

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(
            @Valid @RequestBody CategoryRequest request) {

        CategoryResponse response = categoryService.createCategory(request);

        return ResponseBuilder.created(
                ApiMessages.CREATED,
                response);
    }

    @Operation(summary = "Get All Categories", description = "Returns all active categories.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories() {

        List<CategoryResponse> response = categoryService.getAllCategories();

        return ResponseBuilder.success(
                ApiMessages.FETCHED_ALL,
                response);
    }

    @Operation(summary = "Get Category By Id", description = "Returns category details by category id.")
    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(
            @PathVariable Long categoryId) {

        CategoryResponse response = categoryService.getCategoryById(categoryId);

        return ResponseBuilder.success(
                ApiMessages.FETCHED,
                response);
    }

    @Operation(summary = "Update Category", description = "Updates an existing category.")
    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(
            @PathVariable Long categoryId,
            @Valid @RequestBody CategoryRequest request) {

        CategoryResponse response = categoryService.updateCategory(categoryId, request);

        return ResponseBuilder.success(
                ApiMessages.UPDATED,
                response);
    }

    @Operation(summary = "Delete Category", description = "Soft deletes a category.")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(
            @PathVariable Long categoryId) {

        categoryService.deleteCategoryById(categoryId);

        return ResponseBuilder.success(
                ApiMessages.DELETED);
    }

}