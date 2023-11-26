//package com.mesoneer.pizzastore.service;
//
//import com.mesoneer.pizzastore.entity.Staff;
//import com.mesoneer.pizzastore.mapper.StaffMapper;
//import com.mesoneer.pizzastore.openapi.model.StaffRequestDto;
//import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;
//import com.mesoneer.pizzastore.repository.StaffRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class StaffServiceImpl implements StaffService {
//
//    private final StaffRepository staffRepository;
//    private final StaffMapper staffMapper;
//
//    public StaffResponseDto create(StaffRequestDto requestDto) {
//        Staff entity = new Staff();
//        entity.setRole(requestDto.getRole());
//        entity.setUsername(requestDto.getUsername());
//        staffRepository.save(entity);
////        return null;
//        return staffMapper.toDto(entity);
//    }
//}
