package com.pizzacreed.pizzacreed_backend.exception;

public class BasketAlreadyCheckedOutException extends RuntimeException{
    public BasketAlreadyCheckedOutException(String message) {
        super(message);
    }
}
