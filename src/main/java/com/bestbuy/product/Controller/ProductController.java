package com.bestbuy.product.Controller;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;
import com.bestbuy.product.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    // ========== READ ONE (GET /api/products/{id}) ==========
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(
            @PathVariable String id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // ========== READ ALL (GET /api/products) ==========
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // ========== UPDATE (PUT /api/products/{id}) ==========
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable String id,
            @Valid @RequestBody ProductRequestDTO dto){
        return ResponseEntity.ok(productService.updateProduct(id,dto));
    }

    // ========== DELETE (DELETE /api/products/{id}) ==========
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable String id
    ){
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
