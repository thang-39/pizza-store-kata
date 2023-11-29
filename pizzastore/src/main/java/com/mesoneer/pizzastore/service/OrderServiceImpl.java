package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.entity.Status;
import com.mesoneer.pizzastore.mapper.OrderMapper;
import com.mesoneer.pizzastore.openapi.model.*;

import com.mesoneer.pizzastore.repository.OrderRepository;
import com.mesoneer.pizzastore.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final OrderMapper orderMapper;


    @Override
    public OrderResponseDto placeOrder(OrderCreateDto orderDto) {
        List<OrderItemCreateDto> orderItemDtos = orderDto.getOrderItems();

        Order orderEntity = Order.builder()
                .bookingDate(LocalDateTime.now())
                .customerName(orderDto.getCustomerName())
                .phoneNumber(orderDto.getPhoneNumber())
                .deliveryTo(orderDto.getDeliveryTo())
                .status(Status.PENDING)
                .finalAmount(orderDto.getFinalAmount())
                .build();
        orderEntity = orderRepository.save(orderEntity);

        List<OrderItem> orderItemEntities = new ArrayList<>();
        for (OrderItemCreateDto dto : orderItemDtos) {
            orderItemEntities.add(orderItemService.createOrderItem(orderEntity, dto));
        }
        orderEntity.setOrderItems(orderItemEntities);
        orderEntity = orderRepository.save(orderEntity);

        return orderMapper.toOrderResponseDto(orderEntity);
    }

    @Override
    public OrderResponseDto changeOrderStatus(Integer id, OrderStatusDto orderStatusDto) {
        Order entity = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, Order.class));
        entity.setStatus(Status.fromValue(orderStatusDto.getStatus().getValue()));
        return orderMapper.toOrderResponseDto(orderRepository.save(entity));
    }
}
