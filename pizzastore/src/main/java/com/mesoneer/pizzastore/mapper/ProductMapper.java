package com.mesoneer.pizzastore.mapper;

import com.mesoneer.pizzastore.entity.Image;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.openapi.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "images", source = "images", qualifiedByName = "imageListToStringList")
    ProductDto toDto(Product product);

    @Named("imageListToStringList")
    default List<String> imageListToStringList(List<Image> images) {
        List<String> imageStrings = new ArrayList<>();
        for (Image image : images) {
            imageStrings.add(image.getContentType() + "," + image.getBase64Content());
        }
        return imageStrings;
    }
}
