package com.mesoneer.pizzastore.service;

import com.mesoneer.pizzastore.entity.Staff;
import com.mesoneer.pizzastore.exception.NotFoundException;
import com.mesoneer.pizzastore.mapper.StaffMapper;
import com.mesoneer.pizzastore.openapi.model.StaffRequestDto;
import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;
import com.mesoneer.pizzastore.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public StaffResponseDto create(StaffRequestDto requestDto) {
        Staff entity = new Staff();
        entity.setRole(requestDto.getRole());
        entity.setUsername(requestDto.getUsername());
        entity.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        staffRepository.save(entity);
        return staffMapper.toDto(entity);
    }

    @Override
    public Staff getUserByUsername(String username) {
        return staffRepository.getByUsername(username)
                .orElseThrow(() -> new NotFoundException("Staff with username: '" + username + "' not in our record"));
    }
}
