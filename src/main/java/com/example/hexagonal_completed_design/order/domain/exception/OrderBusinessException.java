package com.example.hexagonal_completed_design.order.domain.exception;

public class OrderBusinessException extends RuntimeException {
    public OrderBusinessException(String message) {
        super(message);
    }
}
