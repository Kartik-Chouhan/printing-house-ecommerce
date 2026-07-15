package com.printing_house_backend.category.entity;

import jakarta.persistence.*;
import lombok.*;


import com.printing_house_backend.common.BaseEntity;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @Column(length = 500)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(nullable = false)
    private Boolean isActive = true;
}