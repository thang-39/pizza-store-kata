package com.mesoneer.pizzastore.repository;

import com.mesoneer.pizzastore.entity.Order;
import com.mesoneer.pizzastore.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByStatus(Status status);
}
