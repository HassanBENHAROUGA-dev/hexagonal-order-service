package com.example.hexagonal_completed_design.order.adapter.in.rest.dto.request;

import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;

import java.math.BigDecimal;

public record DiscountRequest(OrderId orderId, BigDecimal amount) {
}
