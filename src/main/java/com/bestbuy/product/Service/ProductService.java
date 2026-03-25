package com.bestbuy.product.Service;

import com.bestbuy.product.Dto.Product.ProductRequestDTO;
import com.bestbuy.product.Dto.Product.ProductResponseDTO;
import com.bestbuy.product.Exception.ProductNotFoundException;
import com.bestbuy.product.Mapper.ProductMapper;
import com.bestbuy.product.Model.Product;
import com.bestbuy.product.Repository.ProductRepository;
import com.bestbuy.product.Service.Interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository repository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        Product savedProduct = repository.save(product);
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public ProductResponseDTO getProduct(String id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.toDto(product);
    }

    //    If you have 1,000 products, you don't want to pack 1,000 to-go boxes manually.
    //    This uses a powerful Java feature called Streams (think of it as a conveyor belt):
    //
    //    .findAll(): Grabs everything from the database.
    //
    //    .stream(): Puts all the raw products onto a moving conveyor belt.
    //
    //    .map(ProductMapper::toDTO): As each product moves down the belt,
    //    the Mapper quickly grabs it and shoves it into a Response DTO to-go box.
    //
    //    .collect(...): Collects all the to-go boxes at the end of the belt
    //    into a single List and hands them to the Waiter.
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        ProductMapper.updateEntity(product, dto);
        return ProductMapper.toDto(repository.save(product));
    }

    @Override
    public void deleteProduct(String id) {
        if (!repository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
