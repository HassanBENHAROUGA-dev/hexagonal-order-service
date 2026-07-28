package com.example.hexagonal_completed_design.order.infrastructure.config;

import com.example.hexagonal_completed_design.order.application.port.in.ManageOrderUseCase;
import com.example.hexagonal_completed_design.order.application.port.out.DiscountPort;
import com.example.hexagonal_completed_design.order.application.port.out.EventPublisherPort;
import com.example.hexagonal_completed_design.order.application.port.out.PaymentPort;
import com.example.hexagonal_completed_design.order.application.port.out.ShipPort;
import com.example.hexagonal_completed_design.order.application.service.OrderApplicationService;
import com.example.hexagonal_completed_design.order.domain.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public ManageOrderUseCase manageOrderUseCase(
            OrderRepository orderRepository,
            PaymentPort paymentPort,
            EventPublisherPort eventPublisherPort,
            ShipPort shipPort,
            DiscountPort discountPort) {

        // On instancie notre service métier pur Java en lui passant les beans Spring
        return new OrderApplicationService(
                orderRepository,
                paymentPort,
                eventPublisherPort,
                shipPort,
                discountPort
        );
    }
}