package com.bestbuy.product.Mapper;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;
import com.bestbuy.product.Model.Enum.ProductStatus;
import com.bestbuy.product.Model.Product;

import java.time.Instant;

public class ProductMapper {
    // Build the product for the creation of products
    // convert client request to database model
    public static Product toEntity(ProductRequestDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .imageUrl(dto.getImageUrl())
                .status(ProductStatus.ACTIVE)
                .createdAt(Instant.now()) // so initially all products are active
                .updatedAt(Instant.now())
                .build();
    }

    // Convert model to response
    //    .name(): This converts the strict Java Enum into a plain English text string.
    //    It turns the code object ProductStatus.ACTIVE into the simple word "ACTIVE"
    //    so it can easily travel over the internet to Angular.
    public static ProductResponseDTO toDto(Product product) {
        if (product == null) return null;

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory().name())
                .imageUrl(product.getImageUrl())
                .status(product.getStatus().name())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();

    }

    // Update mapper
    public static void updateEntity(Product product, ProductRequestDTO dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setImageUrl(dto.getImageUrl());
        product.setStatus(dto.getStatus());
        product.setUpdatedAt(Instant.now());
    }

}
