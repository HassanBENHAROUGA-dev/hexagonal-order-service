package com.example.hexagonal_completed_design.order.adapter.in.rest.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record AddItemRequest(UUID productId, int quantity, BigDecimal amount, String currency) {}