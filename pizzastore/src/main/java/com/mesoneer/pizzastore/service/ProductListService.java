package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.openapi.model.ProductDto;

import java.util.List;

public interface ProductListService {
    List<ProductDto> getAllProduct();

    List<ProductDto> getProductByCategory(String category);
}
