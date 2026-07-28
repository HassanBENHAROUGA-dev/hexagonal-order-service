package com.example.hexagonal_completed_design.order.domain.valueobject;

import java.math.BigDecimal;

public record Discount(BigDecimal percentage, String codePromo) {
    public Discount {
        if (percentage == null) throw new IllegalArgumentException("Percentage cannot be null");
        if (codePromo == null || codePromo.isEmpty()) throw new IllegalArgumentException("Code Promo cannot be null or empty");
    }
}
