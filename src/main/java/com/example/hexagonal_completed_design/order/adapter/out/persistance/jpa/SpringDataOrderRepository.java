package com.example.hexagonal_completed_design.order.adapter.out.persistance.jpa;

import com.example.hexagonal_completed_design.order.adapter.out.persistance.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, UUID> {
}