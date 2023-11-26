package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.openapi.model.OrderCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderStatusDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderCreateDto orderDto);

    OrderResponseDto changeOrderStatus(Integer id, OrderStatusDto orderStatusDto);
}
