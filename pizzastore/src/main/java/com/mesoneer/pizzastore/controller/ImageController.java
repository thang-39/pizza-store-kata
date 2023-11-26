//package com.mesoneer.pizzastore.controller;
//
//import com.mesoneer.pizzastore.openapi.api.ImagesApi;
//import com.mesoneer.pizzastore.openapi.model.ImageDto;
//import com.mesoneer.pizzastore.service.ImageService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.UUID;
//
//@RestController
//@RequiredArgsConstructor
//public class ImageController implements ImagesApi {
//    private final ImageService imageService;
//
//    @Override
//    public ResponseEntity<ImageDto> saveImagesPizza(UUID id, MultipartFile images){
//        return new ResponseEntity<>(imageService.savePizzaImages(id, images), HttpStatus.CREATED);
//    }
//}
