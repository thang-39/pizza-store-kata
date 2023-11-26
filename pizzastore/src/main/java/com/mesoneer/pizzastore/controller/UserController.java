//package com.mesoneer.pizzastore.controller;
//
//
//
//import com.mesoneer.pizzastore.openapi.api.StaffApi;
//import com.mesoneer.pizzastore.openapi.model.StaffRequestDto;
//import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;
//import com.mesoneer.pizzastore.service.StaffService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class UserController implements StaffApi {
//
//    private final StaffService staffService;
//
//    @Override
//    public ResponseEntity<StaffResponseDto> createStaff(@RequestBody StaffRequestDto staffRequestDto) {
//
//        return new ResponseEntity<>(staffService.create(staffRequestDto), HttpStatus.CREATED);
//    }
//}
