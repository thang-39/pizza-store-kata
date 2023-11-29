package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.entity.Status;
import com.mesoneer.pizzastore.mapper.OrderMapper;
import com.mesoneer.pizzastore.openapi.model.*;
import com.mesoneer.pizzastore.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderItemServiceImpl orderItemService;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

    static OrderCreateDto orderCreateDto;
    static Order orderEntity;
    static OrderItem orderItem;
    static Product pizza1;
    static OrderItemCreateDto orderItemCreateDto;
    static OrderResponseDto orderResponseDto;
    @BeforeEach
    void setup() {
        orderItemCreateDto = new OrderItemCreateDto(
                UUID.randomUUID(),
                2,
                24.2F);
        orderCreateDto = new OrderCreateDto(
                "Thang",
                "09090909090",
                "152 Dien Bien Phu",
                24.2F,
                List.of(orderItemCreateDto)
                );
        orderEntity = Order.builder()
                .bookingDate(LocalDateTime.now())
                .customerName(orderCreateDto.getCustomerName())
                .phoneNumber(orderCreateDto.getPhoneNumber())
                .deliveryTo(orderCreateDto.getDeliveryTo())
                .status(Status.PENDING)
                .finalAmount(orderCreateDto.getFinalAmount())
                .build();
        pizza1 = Product.builder()
                .category("pizza")
                .name("pizza1")
                .description("1 is one")
                .price(12.10F)
                .build();
        orderItem = OrderItem.builder()
                .order(orderEntity)
                .quantity(2)
                .totalAmount(24.2F)
                .product(pizza1)
                .build();
        orderResponseDto = new OrderResponseDto();

    }
    @Test
    void placeOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(orderEntity);
        when(orderItemService.createOrderItem(any(),any())).thenReturn(orderItem);
        when(orderMapper.toOrderResponseDto(any())).thenReturn(orderResponseDto);
        //act
        orderService.placeOrder(orderCreateDto);
        //verify
        verify(orderRepository, times(2)).save(any());
    }

    @Test
    void changeOrderStatus() {
        OrderStatusDto orderStatusDto = new OrderStatusDto(StatusDto.DONE);
        when(orderRepository.save(any(Order.class))).thenReturn(orderEntity);
        when(orderRepository.findById(any())).thenReturn(Optional.of(orderEntity));
        orderResponseDto.setStatus(orderStatusDto.getStatus());
        when(orderMapper.toOrderResponseDto(any())).thenReturn(orderResponseDto);
        // act
        OrderResponseDto orderResponseDto1 = orderService.changeOrderStatus(any(), orderStatusDto);
        // assert
        assertEquals(StatusDto.DONE, orderResponseDto1.getStatus());
    }
}