package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.OrderItem;
import com.mesoneer.pizzastore.entity.Product;
import com.mesoneer.pizzastore.exception.NotFoundException;
import com.mesoneer.pizzastore.mapper.OrderItemMapper;
import com.mesoneer.pizzastore.openapi.model.OrderItemCreateDto;
import com.mesoneer.pizzastore.repository.OrderItemRepository;
import com.mesoneer.pizzastore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItem createOrderItem(Order orderEntity, OrderItemCreateDto dto) {
        Product productEntity = productRepository.findById(dto.getProductId())
                .orElseThrow(()-> new NotFoundException(dto.getProductId().toString(), Product.class));

        return orderItemRepository.save(OrderItem.builder()
                .order(orderEntity)
                .product(productEntity)
                .quantity(dto.getQuantity())
                .totalAmount(dto.getTotalAmount())
                .build());
    }
}
