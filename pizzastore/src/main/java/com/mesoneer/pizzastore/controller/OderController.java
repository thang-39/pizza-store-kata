package com.mesoneer.pizzastore.controller;

import com.mesoneer.pizzastore.openapi.api.OrdersApi;
import com.mesoneer.pizzastore.openapi.model.OrderCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderStatusDto;
import com.mesoneer.pizzastore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OderController implements OrdersApi {
    private final OrderService orderService;
    @Override
    public ResponseEntity<OrderResponseDto> placeOrder(OrderCreateDto orderDto) {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<OrderResponseDto> changeOrderStatus(Integer id, OrderStatusDto orderStatusDto) {
        return new ResponseEntity<>(orderService.changeOrderStatus(id, orderStatusDto), HttpStatus.OK);
    }
}
