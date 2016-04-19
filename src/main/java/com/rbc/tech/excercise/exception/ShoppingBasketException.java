package com.rbc.tech.excercise.exception;

public class ShoppingBasketException extends RuntimeException {
    public ShoppingBasketException(String message, Exception exception) {
        super(message, exception);
    }
}
