package com.example.hexagonal_completed_design.order.adapter.in.rest.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record DiscountedOrderResponse(UUID orderId, BigDecimal amount, BigDecimal discountedAmount, String codePromo, BigDecimal percentage) {
}
