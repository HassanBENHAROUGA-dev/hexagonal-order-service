package com.example.hexagonal_completed_design.order.domain.repository;

import com.example.hexagonal_completed_design.order.domain.aggregate.Order;
import com.example.hexagonal_completed_design.order.domain.valueobject.OrderId;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(OrderId id);
}