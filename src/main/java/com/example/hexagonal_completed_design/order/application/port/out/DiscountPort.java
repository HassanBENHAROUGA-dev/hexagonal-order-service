package com.example.hexagonal_completed_design.order.application.port.out;

import java.math.BigDecimal;


public interface DiscountPort {
    boolean checkPromoCode(String promoCode);
    BigDecimal getDiscount(String promoCode);
}
