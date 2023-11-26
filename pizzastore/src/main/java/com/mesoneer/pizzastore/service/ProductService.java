package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.openapi.model.ProductDto;

import java.util.UUID;

public interface ProductService {
    ProductDto create(ProductDto pizzaDto);

    void deleteById(UUID id);
}
