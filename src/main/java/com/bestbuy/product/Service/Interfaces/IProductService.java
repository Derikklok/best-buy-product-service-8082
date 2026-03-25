package com.bestbuy.product.Service.Interfaces;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;
import com.bestbuy.product.Model.Enum.ProductCategory;
import com.bestbuy.product.Model.Enum.ProductStatus;

import java.util.List;

public interface IProductService {
    //    CREATE - Add new product
    ProductResponseDTO createProduct(ProductRequestDTO dto);

    //    READ ONE - Get one single product by id
    ProductResponseDTO getProduct(String id);

    //    READ ALL - Get all products
    List<ProductResponseDTO> getAllProducts();

    //    UPDATE - Modify existing product info
    ProductResponseDTO updateProduct(String id, ProductRequestDTO dto);

    //    DELETE - Remove product
    void deleteProduct(String id);

    //    GET - Search or find by category, Filtering
    List<ProductResponseDTO> findByCategory(ProductCategory category);

    //    GET - Filter by status
    List<ProductResponseDTO> findByStatus(ProductStatus status);
}
