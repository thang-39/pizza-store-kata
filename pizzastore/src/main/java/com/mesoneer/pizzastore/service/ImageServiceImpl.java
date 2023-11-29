//package com.mesoneer.pizzastore.service;
//
//import com.mesoneer.pizzastore.entity.Image;
//import com.mesoneer.pizzastore.entity.Pizza;
//import com.mesoneer.pizzastore.entity.Product;
//import com.mesoneer.pizzastore.exception.ImageUploadException;
//import com.mesoneer.pizzastore.mapper.ImageMapper;
//import com.mesoneer.pizzastore.openapi.model.ImageDto;
//import com.mesoneer.pizzastore.repository.ImageRepository;
//import com.mesoneer.pizzastore.repository.PizzaRepository;
//import com.mesoneer.pizzastore.repository.ProductRepository;
//import exception.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class ImageServiceImpl implements ImageService {
//
//    private static final String IMAGE_DIR =  "src/main/resources/static/images/";
//    private final ImageMapper imageMapper;
//    private final ImageRepository imageRepository;
//    private final ProductRepository productRepository;
//
//    @Override
//    public ImageDto savePizzaImages(UUID id, MultipartFile file) {
//        Product productEntity = productRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(id, Product.class));
//
//        // Generate a unique filename for the image
//        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
//
//        Path imagesFolderPath = Path.of(IMAGE_DIR).toAbsolutePath().normalize();
//        Path targetPath;
//        try {
//            // Create the directory if it doesn't exist
//            if (!Files.exists(imagesFolderPath)) {
//                Files.createDirectories(imagesFolderPath);
//            }
//
//            // Copy the image file to the target directory
//            targetPath = imagesFolderPath.resolve(fileName);
//            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            throw new ImageUploadException(ex);
//        }
//
//        Image entity = imageRepository.save(Image.builder()
//                .name(file.getOriginalFilename())
//                .contentType(file.getContentType())
////                .filePath(targetPath.toString())
//                .product(productEntity)
//                .build());
//
//        return imageMapper.toProductImageDto(entity);
//    }
//}
