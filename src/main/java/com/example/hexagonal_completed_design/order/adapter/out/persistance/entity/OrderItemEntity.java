package com.example.hexagonal_completed_design.order.adapter.out.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID productId;
    private int quantity;
    private BigDecimal unitPrice;
    private String currency;

    protected OrderItemEntity() {}

    public OrderItemEntity(UUID productId, int quantity, BigDecimal unitPrice, String currency) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.currency = currency;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public UUID getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public String getCurrency() { return currency; }
}