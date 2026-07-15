package com.printing_house_backend.category.mapper;

import com.printing_house_backend.category.dto.CategoryRequest;
import com.printing_house_backend.category.dto.CategoryResponse;
import com.printing_house_backend.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    
    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);

    List<CategoryResponse> toResponseList(List<Category> categories);
}