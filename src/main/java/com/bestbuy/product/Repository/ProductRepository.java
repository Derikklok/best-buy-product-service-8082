package com.bestbuy.product.Repository;

import com.bestbuy.product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
