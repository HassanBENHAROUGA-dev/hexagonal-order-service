package com.example.hexagonal_completed_design.order.domain.valueobject;

import com.example.hexagonal_completed_design.order.domain.identifier.Identifier;

import java.util.UUID;

public record ProductId(UUID value) implements Identifier<UUID> {
    public ProductId {
        if (value == null) throw new IllegalArgumentException("ProductId cannot be null");
    }
}