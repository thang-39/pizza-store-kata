package com.mesoneer.pizzastore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Status {
    PENDING("PENDING"), CANCEL("CANCEL"), CONFIRMED("CONFIRMED"), COOKED("COOKED"), DONE("DONE");
    private final String value;

    public static Status fromValue(String value) {
        for (Status type : Status.values()) {
            if (type.getValue().equals(value))
                return type;
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}
