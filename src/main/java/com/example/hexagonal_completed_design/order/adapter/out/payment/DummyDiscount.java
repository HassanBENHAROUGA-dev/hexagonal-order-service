package com.example.hexagonal_completed_design.order.adapter.out.payment;

import com.example.hexagonal_completed_design.order.application.port.out.DiscountPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class DummyDiscount implements DiscountPort {
    private static final Map<String, BigDecimal> PROMO_CODES = Map.of(
            "WELCOME10", BigDecimal.valueOf(10),
            "SUMMER20", BigDecimal.valueOf(20),
            "BLACKFRIDAY", BigDecimal.valueOf(50),
            "VIP50", BigDecimal.valueOf(50),
            "FREESHIP", BigDecimal.valueOf(100),
            "PROMO2026", BigDecimal.valueOf(25)
    );
    @Override
    public boolean checkPromoCode(String promoCode) {
        return PROMO_CODES.containsKey(promoCode);
    }

    @Override
    public BigDecimal getDiscount(String promoCode){
        return PROMO_CODES.get(promoCode);
    }
}
