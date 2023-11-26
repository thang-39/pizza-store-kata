package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.openapi.model.OrderItemCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderItemResponseDto;

public interface OrderItemService {
    OrderItem createOrderItem(Order orderEntity, OrderItemCreateDto dto);
}
