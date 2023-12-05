package com.mesoneer.pizzastore.repository;

import com.mesoneer.pizzastore.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> getByUsername(String username);
}
