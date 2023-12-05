package com.mesoneer.pizzastore.controller;

import com.mesoneer.pizzastore.openapi.api.LoginApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {

    @Override
    public ResponseEntity<Void> login() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
