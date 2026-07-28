package com.example.hexagonal_completed_design.order.application.command;

import java.util.UUID;

public record CreateOrderCommand(UUID orderId) {}
