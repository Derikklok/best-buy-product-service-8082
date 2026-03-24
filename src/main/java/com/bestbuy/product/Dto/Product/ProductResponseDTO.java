package com.bestbuy.product.Dto.Product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private String status;
    private String imageUrl;
    private Instant createdAt;
    private Instant updatedAt;
}
