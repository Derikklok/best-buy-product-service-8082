package com.bestbuy.product.Controller;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;
import com.bestbuy.product.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // ========== CREATE (POST /api/products) ==========
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO dto) {
        ProductResponseDTO created = productService.createProduct(dto);

        return ResponseEntity
                .created(URI.create("/api/products" + created.getId()))
                .body(created);
    }

}
