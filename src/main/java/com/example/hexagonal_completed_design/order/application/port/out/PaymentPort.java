package com.example.hexagonal_completed_design.order.application.port.out;

import com.example.hexagonal_completed_design.order.domain.valueobject.Money;
import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;

public interface PaymentPort {
    boolean processPayment(OrderId orderId, Money amount);
}