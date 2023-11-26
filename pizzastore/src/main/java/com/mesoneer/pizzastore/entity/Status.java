package com.mesoneer.pizzastore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Status {
    PENDING("PENDING"), CONFIRMED("CONFIRMED"), COOKED("COOKED"), DONE("DONE");
    private final String value;

    private static final Map<String, Status> lookup = new HashMap<>();

    static {
        for (Status d : Status.values()) {
            lookup.put(d.getValue(), d);
        }
    }
    public static Status fromValue(String value) {
        return lookup.get(value);
    }

}
