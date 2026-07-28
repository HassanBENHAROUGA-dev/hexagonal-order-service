package com.example.hexagonal_completed_design.order.adapter.out.payment;


import com.example.hexagonal_completed_design.order.application.port.out.PaymentPort;
import com.example.hexagonal_completed_design.order.domain.valueobject.Money;
import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;
import org.springframework.stereotype.Component;

//A mock for test
@Component
public class DummyPaymentAdapter implements PaymentPort {

    @Override
    public boolean processPayment(OrderId orderId, Money amount) {
        // Appel API externe (Stripe, Adyen, etc.) simulé
        System.out.println("Processing payment of " + amount.amount() + " " + amount.currency() + " for order " + orderId.value());
        return true;
    }
}