package com.mesoneer.pizzastore.controller;

import com.mesoneer.pizzastore.openapi.api.OrdersApi;
import com.mesoneer.pizzastore.openapi.model.OrderCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderStatusDto;
import com.mesoneer.pizzastore.service.OrderService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class OderController implements OrdersApi {
    private final OrderService orderService;
    @Override
    public ResponseEntity<OrderResponseDto> placeOrder(OrderCreateDto orderDto) {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.OK);
    }

//    @RolesAllowed(value = {"RECEPTIONIST", "SHIPPER", "CHEF"})
//    @RolesAllowed(value = {"ROLE_RECEPTIONIST", "ROLE_SHIPPER", "ROLE_CHEF"})
//    @RolesAllowed(value = {"RECEPTIONIST", "SHIPPER", "CHEF"})
//    @PreAuthorize("hasRole('ROLE_RECEPTIONIST') or hasRole('ROLE_SHIPPER') or hasRole('ROLE_CHEF')")
    @PreAuthorize("hasRole('RECEPTIONIST') || hasRole('SHIPPER') || hasRole('CHEF')")
    @Override
    public ResponseEntity<List<OrderResponseDto>> getOrdersByStatus(String status) {
        return new ResponseEntity<>(orderService.getOrderByStatus(status), HttpStatus.OK);
    }

//    @Secured({"ROLE_RECEPTIONIST", "ROLE_SHIPPER", "ROLE_CHEF"})
    @Override
//    @PreAuthorize("hasRole('ROLE_RECEPTIONIST') or hasRole('ROLE_SHIPPER') or hasRole('ROLE_CHEF')")
    @PreAuthorize("hasRole('RECEPTIONIST') || hasRole('SHIPPER') || hasRole('CHEF')")
    public ResponseEntity<OrderResponseDto> changeOrderStatus(Integer id, OrderStatusDto orderStatusDto) {
        return new ResponseEntity<>(orderService.changeOrderStatus(id, orderStatusDto), HttpStatus.OK);
    }


}
