package com.example.hexagonal_completed_design.order.application.port.out;

import com.example.hexagonal_completed_design.order.domain.domainEvent.DomainEvent;

public interface EventPublisherPort {
    void publish(DomainEvent event);
}