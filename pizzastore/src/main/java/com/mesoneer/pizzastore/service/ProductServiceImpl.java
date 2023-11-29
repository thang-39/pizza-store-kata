package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Image;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.mapper.ProductMapper;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import com.mesoneer.pizzastore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto create(ProductDto productDto) {
        String productName = productDto.getName();

        Product entity = productRepository.save(Product.builder()
                .name(productName)
                .category(productDto.getCategory())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build());

        List<Image> imageEntityList = new ArrayList<>();

        List<String> images = productDto.getImages();
        for (String img : images) {
            String[] imageDataArray = img.split(",");
            Image imgEntity = Image.builder()
                    .name(productName + "-" + UUID.randomUUID())
                    .contentType(imageDataArray[0])
                    .base64Content(imageDataArray[1])
                    .product(entity)
                    .build();
            imageEntityList.add(imgEntity);
        }

        entity.setImages(imageEntityList);
        entity = productRepository.save(entity);

        return productMapper.toDto(entity);
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        return productRepository.findByCategory(category).stream().map(productMapper::toDto).toList();
    }

//    public ImageDto savePizzaImage(Pizza pizzaEntity, String imageData) {
//        String[] imageDataArray = imageData.split(",");
//        Image entity = Image.builder()
//                .name(pizzaEntity.getName() + "-" + UUID.randomUUID())
//                .contentType(imageDataArray[0])
//                .base64Content(imageDataArray[1])
//                .pizza(pizzaEntity)
//                .build();
//        imageRepository.save(entity);
//        return imageMapper.toPizzaImageDto(entity);
//    }


}
