package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.openapi.model.OrderCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderStatusDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    OrderResponseDto placeOrder(OrderCreateDto orderDto);

    OrderResponseDto changeOrderStatus(Integer id, OrderStatusDto orderStatusDto);

    OrderResponseDto changeOrderStatus(Integer id);

    List<OrderResponseDto> getOrderByStatus(String status);
}
