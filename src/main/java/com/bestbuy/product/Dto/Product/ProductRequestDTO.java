package com.bestbuy.product.Dto.Product;

import com.bestbuy.product.Model.Enum.ProductCategory;
import com.bestbuy.product.Model.Enum.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Category is required")
    private ProductCategory category;

    @NotNull(message = "Status is required")
    private ProductStatus status;

    private String imageUrl;
}
