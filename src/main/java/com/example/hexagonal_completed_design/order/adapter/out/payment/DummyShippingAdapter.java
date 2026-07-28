package com.example.hexagonal_completed_design.order.adapter.out.payment;

import com.example.hexagonal_completed_design.order.application.port.out.ShipPort;
import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DummyShippingAdapter implements ShipPort {

    private static final Random RANDOM = new Random();

    @Override
    public String getShippingNumber(OrderId orderId) {
        int number = 100_000_000 + RANDOM.nextInt(900_000_000);
        System.out.println("COLIS-" + number + " for order " + orderId.value());
        return "COLIS-" + number;
    }
}
