package com.example.hexagonal_completed_design.order.application.port.in;

import com.example.hexagonal_completed_design.order.application.command.*;

public interface ManageOrderUseCase {
    void createOrder(CreateOrderCommand command);
    void addOrderItem(AddOrderItemCommand command);
    void confirmOrder(ConfirmOrderCommand command);
    void cancelOrder(CancelOrderCommand command);
    void shipOrder(ShipOrderCommand command);
    void applyDiscount(DiscountCommand command, String codePromo);
}