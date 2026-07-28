package com.example.hexagonal_completed_design.order.domain.valueobject;

import com.example.hexagonal_completed_design.order.domain.identifier.Identifier;

import java.util.UUID;

public record OrderId(UUID value) implements Identifier<UUID> {
    public OrderId {
        if (value == null) throw new IllegalArgumentException("OrderId cannot be null");
    }
}