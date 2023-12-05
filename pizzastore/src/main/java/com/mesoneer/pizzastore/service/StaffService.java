package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Staff;
import com.mesoneer.pizzastore.openapi.model.StaffRequestDto;
import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;

public interface StaffService {
    StaffResponseDto create(StaffRequestDto requestDto);

    Staff getUserByUsername(String username);
}
