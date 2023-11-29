package com.mesoneer.pizzastore.controller;

import com.mesoneer.pizzastore.openapi.api.ProductsApi;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import com.mesoneer.pizzastore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDto> addProduct(ProductDto productDto) {
        return new ResponseEntity<>(productService.create(productDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteProductById(UUID id) {
        productService.deleteById(id);
        return new ResponseEntity<>("Deleted " + id , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAll() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductByCategory(String category) {
        return new ResponseEntity<>(productService.getProductsByCategory(category), HttpStatus.OK);
    }
}
