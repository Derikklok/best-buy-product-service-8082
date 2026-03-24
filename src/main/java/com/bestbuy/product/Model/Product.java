package com.bestbuy.product.Model;


import com.bestbuy.product.Model.Enum.ProductCategory;
import com.bestbuy.product.Model.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private Instant createdAt;

    private Instant updatedAt;
}
