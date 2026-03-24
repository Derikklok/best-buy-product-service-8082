package com.bestbuy.product.Service.Interfaces;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;

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
}
