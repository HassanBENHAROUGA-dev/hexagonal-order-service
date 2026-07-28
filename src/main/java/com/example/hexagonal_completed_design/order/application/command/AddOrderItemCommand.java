package com.example.hexagonal_completed_design.order.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public record AddOrderItemCommand(
        UUID orderId,
        UUID productId,
        int quantity,
        BigDecimal amount,
        String currency
) {}