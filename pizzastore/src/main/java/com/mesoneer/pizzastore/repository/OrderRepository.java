package com.mesoneer.pizzastore.repository;

import com.mesoneer.pizzastore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
