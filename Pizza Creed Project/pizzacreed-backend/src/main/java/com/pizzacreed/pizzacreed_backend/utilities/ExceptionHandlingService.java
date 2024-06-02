package com.pizzacreed.pizzacreed_backend.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandlingService {
    public static ResponseEntity<Object> handleRestException(Exception ex, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", status.value());
        return new ResponseEntity<>(response, status);
    }
}
