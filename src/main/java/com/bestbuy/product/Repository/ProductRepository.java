package com.bestbuy.product.Repository;

import com.bestbuy.product.Model.Enum.ProductCategory;
import com.bestbuy.product.Model.Enum.ProductStatus;
import com.bestbuy.product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    // ========== Find by Status ==========
    List<Product> findByStatus(ProductStatus status);

    // ========== Find by Category ==========
    List<Product> findByCategory(ProductCategory category);
}
