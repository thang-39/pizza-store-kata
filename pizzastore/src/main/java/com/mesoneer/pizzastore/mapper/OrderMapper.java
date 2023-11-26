package com.mesoneer.pizzastore.mapper;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.openapi.model.OrderItemResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = OrderItemMapper.class
)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

//    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "orderItemEntityListToOrderItemResponseDtoList")
    OrderResponseDto toOrderResponseDto(Order entity);

//    @Named("orderItemEntityListToOrderItemResponseDtoList")
//    default List<OrderItemResponseDto> orderItemEntityListToOrderItemResponseDtoList(List<OrderItem> orderItems) {
//
//    }
}
