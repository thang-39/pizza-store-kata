package com.mesoneer.pizzastore.mapper;

import com.mesoneer.pizzastore.entity.Image;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.openapi.model.ImageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    @Mapping(target = "productId", source = "product", qualifiedByName = "productEntityToProductId")
    ImageDto toProductImageDto(Image entity);

    @Named("productEntityToProductId")
    default UUID productEntityToProductId(Product productEntity) {
        return productEntity.getId();
    }
}
