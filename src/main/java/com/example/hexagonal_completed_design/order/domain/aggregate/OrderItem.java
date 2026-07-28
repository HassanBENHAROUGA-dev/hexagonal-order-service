package com.example.hexagonal_completed_design.order.domain.aggregate;

import com.example.hexagonal_completed_design.order.domain.exception.OrderBusinessException;
import com.example.hexagonal_completed_design.order.domain.valueobject.Money;
import com.example.hexagonal_completed_design.order.domain.valueobject.ProductId;

public class OrderItem {
    private final ProductId productId;
    private int quantity;
    private final Money unitPrice;

    // Le constructeur est package-private. Seul l'Order peut créer des items.
    OrderItem(ProductId productId, int quantity, Money unitPrice) {
        if (quantity <= 0) {
            throw new OrderBusinessException("Quantity must be strictly positive");
        }
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ProductId getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public Money getUnitPrice() { return unitPrice; }

    public Money calculateTotal() {
        return unitPrice.multiply(quantity);
    }

    void addQuantity(int additionalQuantity) {
        if (additionalQuantity <= 0) throw new OrderBusinessException("Additional quantity must be positive");
        this.quantity += additionalQuantity;
    }

    public static OrderItem restore(ProductId productId, int quantity, Money unitPrice) {
        return new OrderItem(productId, quantity, unitPrice);
    }
}