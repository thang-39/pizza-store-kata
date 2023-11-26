package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.mapper.ProductMapper;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import com.mesoneer.pizzastore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public List<ProductDto> getProductByCategory(String category) {
        return productRepository.findByCategory(category).stream().map(productMapper::toDto).toList();
    }
}
