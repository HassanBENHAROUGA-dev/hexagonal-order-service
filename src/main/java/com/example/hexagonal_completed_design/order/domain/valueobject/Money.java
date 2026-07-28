package com.example.hexagonal_completed_design.order.domain.valueobject;

import com.example.hexagonal_completed_design.order.domain.aggregate.Order;
import com.example.hexagonal_completed_design.order.domain.aggregate.OrderItem;
import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Money(BigDecimal amount, String currency) {
    public Money {
        if (amount == null || currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Money amount and currency are required");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money amount cannot be negative");
        }
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public Money multiply(int multiplier) {
        if (multiplier < 0) throw new IllegalArgumentException("Multiplier cannot be negative");
        return new Money(this.amount.multiply(BigDecimal.valueOf(multiplier)), this.currency);
    }

    public Money applyPercentage(Discount discount) {
        // 1. Calcul du montant de la réduction
        BigDecimal discountAmount = amount
                .multiply(discount.percentage())
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        // 2. Calcul du nouveau total
        BigDecimal newTotal = amount.subtract(discountAmount);

        // 3. Retourne un NOUVEAU Money avec la même devise (immuabilité)
        return new Money(newTotal, this.currency);
    }

    private static @NonNull Money getTotalAmount(Order order) {
        return order.getItems().stream()
                .map(OrderItem::calculateTotal)
                .reduce(new Money(BigDecimal.ZERO, "EUR"), Money::add);
    }
}