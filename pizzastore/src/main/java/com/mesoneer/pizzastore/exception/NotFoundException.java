package com.mesoneer.pizzastore.exception;

import lombok.*;

@Getter
@Setter
public class NotFoundException extends RuntimeException {


    public NotFoundException(Integer id, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with id: '" + id + "' does not exist in our records");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String id, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with id: '" + id + "' does not exist in our records");
    }

}
