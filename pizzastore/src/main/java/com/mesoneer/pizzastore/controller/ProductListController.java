package com.mesoneer.pizzastore.controller;

import com.mesoneer.pizzastore.openapi.api.ProductListApi;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import com.mesoneer.pizzastore.service.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductListController implements ProductListApi {

    private final ProductListService productListService;

    @Override
    public ResponseEntity<List<ProductDto>> getAll() {
        return new ResponseEntity<>(productListService.getAllProduct(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductByCategory(String category) {
        return new ResponseEntity<>(productListService.getProductByCategory(category), HttpStatus.OK);
    }
}
