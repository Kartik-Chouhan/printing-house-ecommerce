package com.printing_house_backend.category.dto;

import java.time.LocalDateTime;

public record CategoryResponse(

        Long categoryId,

        String categoryName,

        String description,

        String imageUrl,

        Integer displayOrder,

        Boolean isActive,

        LocalDateTime createdAt,

        LocalDateTime updatedAt

) {
}