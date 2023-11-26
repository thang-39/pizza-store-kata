package com.mesoneer.pizzastore.repository;

import com.mesoneer.pizzastore.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}
