package com.mesoneer.pizzastore.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private List<String> message;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ErrorMessage(List<String> errorMessage) {
        this.message = errorMessage;
        this.timestamp = LocalDateTime.now();
    }
}
