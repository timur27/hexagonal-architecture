package com.hexagonal.architecture.core.domain.exceptions;

public class OrderUpdateNotPossibleException extends RuntimeException {
    public OrderUpdateNotPossibleException(String message) {
        super(message);
    }
}
