package com.mesoneer.pizzastore.mapper;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.openapi.model.OrderItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(source = "product", target = "productName", qualifiedByName = "productEntityToProductName")
    @Mapping(source = "order", target = "orderId", qualifiedByName = "orderEntityToOrderId")
    OrderItemResponseDto toDto(OrderItem entity);
    @Named("productEntityToProductName")
    default String productEntityToProductName(Product entity) {
        return entity.getName();
    }

    @Named("orderEntityToOrderId")
    default Integer orderEntityToOrderId(Order entity) {
        return entity.getId();
    }

    default List<OrderItemResponseDto> orderItemEntityListToOrderItemResponseDtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::toDto)
                .toList();
    }

}
