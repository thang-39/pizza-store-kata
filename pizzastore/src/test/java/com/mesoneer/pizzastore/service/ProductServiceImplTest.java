package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Image;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.mapper.ProductMapper;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import com.mesoneer.pizzastore.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductServiceImpl productService;

    static ProductDto pizzaDto1;
    static Image imgPizza1;
    static Product pizza1;
    @BeforeEach
    void setUp() {
        pizzaDto1 = new ProductDto("pizza", "pizza1", "1 is one", 12.10F);
        pizzaDto1.addImagesItem("data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==");

        imgPizza1 = Image.builder()
                .product(pizza1)
                .name("imgPizza1")
                .base64Content("data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==")
                .contentType("data:image/gif")
                .build();

        pizza1 = Product.builder()
                .category("pizza")
                .name("pizza1")
                .description("1 is one")
                .price(12.10F)
//                .images(List.of(imgPizza1))
                .build();
    }

    @Test
    void create_product_successfully_whenCreate() {
        // mock
        when(productRepository.save(any(Product.class))).thenReturn(pizza1);
        when(productMapper.toDto(any(Product.class))).thenReturn(pizzaDto1);
//        // act
        productService.create(pizzaDto1);
        // assert
//        assertNotNull(productDto.getImages());
        verify(productRepository, times(2)).save(any(Product.class));
    }

    @Test
    void get_all_products_successfully_whenGetAllProducts() {
        // mock
        when(productRepository.findAll()).thenReturn(List.of(pizza1));
        when(productMapper.toDto(any(Product.class))).thenReturn(pizzaDto1);
        // act
        List<ProductDto> response = productService.getAllProducts();
        // verify
        verify(productRepository, times(1)).findAll();
        // assert
        assertEquals(1, response.size());
    }

    @Test
    void get_all_pizzas_whenGetProductsByCategory() {
        // mock
        when(productRepository.findByCategory(anyString())).thenReturn(List.of(pizza1));
        when(productMapper.toDto(any(Product.class))).thenReturn(pizzaDto1);
        // act
        List<ProductDto> response = productService.getProductsByCategory(anyString());
        // verify
        verify(productRepository, times(1)).findByCategory(anyString());
        // assert
        assertEquals(1, response.size());
    }

    @Test
    void delete_product_whenDeleteById() {
        productService.deleteById(any(UUID.class));
        // act
        verify(productRepository, times(1)).deleteById(any());
    }

}