package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.entity.Status;
import com.mesoneer.pizzastore.openapi.model.OrderItemCreateDto;
import com.mesoneer.pizzastore.repository.OrderItemRepository;
import com.mesoneer.pizzastore.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceImplTest {
    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    static Order orderEntity;
    static OrderItemCreateDto orderItemCreateDto;

    @Test
    public void createOrderItem() {
        Product productEntity = Product.builder()
                .category("pizza")
                .name("pizza1")
                .description("1 is one")
                .price(12.10F)
//                .images(List.of(imgPizza1))
                .build();
        when(productRepository.findById(any())).thenReturn(Optional.of(productEntity));


        Order orderEntity = Order.builder()
                .bookingDate(LocalDateTime.now())
                .customerName("Thang")
                .phoneNumber("09090909090")
                .deliveryTo("152 Dien Bien Phu")
                .status(Status.PENDING)
                .finalAmount(24.2F)
                .build();

        OrderItemCreateDto orderItemCreateDto = new OrderItemCreateDto(
                UUID.randomUUID(),
                2,
                24.1F);

        when(orderItemRepository.save(any())).thenReturn(OrderItem.builder()
                .product(productEntity)
                .order(orderEntity)
                .quantity(orderItemCreateDto.getQuantity())
                .totalAmount(orderItemCreateDto.getTotalAmount())
                .build());
        //act
        OrderItem orderItem = orderItemService.createOrderItem(orderEntity, orderItemCreateDto);


        // assert
        assertEquals(2, orderItem.getQuantity());
    }

}