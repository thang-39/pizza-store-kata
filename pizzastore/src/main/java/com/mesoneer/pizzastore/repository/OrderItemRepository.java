package com.mesoneer.pizzastore.repository;

import com.mesoneer.pizzastore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
