package com.hexagonal.architecture.core.domain.exceptions;

public class OrderNotCreatedException extends RuntimeException {
    public OrderNotCreatedException(String message) {
        super(message);
    }
}
