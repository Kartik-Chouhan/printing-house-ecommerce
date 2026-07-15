package com.printing_house_backend.category.repository;

import com.printing_house_backend.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameAndIsActiveTrue(String categoryName);

    boolean existsByCategoryNameAndIsActiveTrue(String categoryName);

    List<Category> findAllByIsActiveTrueOrderByDisplayOrderAsc();

    boolean existsByCategoryNameAndCategoryIdNotAndIsActiveTrue(
            String categoryName,
            Long categoryId);
}