package com.example.hexagonal_completed_design.order.adapter.in.controller;

import com.example.hexagonal_completed_design.order.adapter.in.rest.dto.request.AddItemRequest;
import com.example.hexagonal_completed_design.order.adapter.in.rest.dto.response.DiscountedOrderResponse;
import com.example.hexagonal_completed_design.order.application.command.*;
import com.example.hexagonal_completed_design.order.application.port.in.ManageOrderUseCase;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@Transactional
public class OrderController {

    private final ManageOrderUseCase manageOrderUseCase;

    public OrderController(ManageOrderUseCase manageOrderUseCase) {
        this.manageOrderUseCase = manageOrderUseCase;
    }

    @PostMapping("/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@PathVariable UUID orderId) {
        manageOrderUseCase.createOrder(new CreateOrderCommand(orderId));
    }

    @PostMapping("/{orderId}/items")
    @ResponseStatus(HttpStatus.OK)
    public void addOrderItem(
            @PathVariable UUID orderId,
            @RequestBody AddItemRequest request) {

        manageOrderUseCase.addOrderItem(new AddOrderItemCommand(
                orderId,
                request.productId(),
                request.quantity(),
                request.amount(),
                request.currency()
        ));
    }

    @PostMapping("/{orderId}/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void confirmOrder(@PathVariable UUID orderId) {
        manageOrderUseCase.confirmOrder(new ConfirmOrderCommand(orderId));
    }

    @PostMapping("/{orderId}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelOrder(@PathVariable UUID orderId) {
        manageOrderUseCase.cancelOrder(new CancelOrderCommand(orderId));
    }

    @PostMapping("/{orderId}/ship")
    @ResponseStatus(HttpStatus.OK)
//    public void shipOrder(@PathVariable UUID orderId, @RequestBody ShipOrderCommand shipOrderCommand) {
    public void shipOrder(@PathVariable UUID orderId) {
        manageOrderUseCase.shipOrder(new ShipOrderCommand(orderId));
    }

    @PostMapping("/{orderId}/discount/{codePromo}")
    @ResponseStatus(HttpStatus.OK)
    public void discountOrder(@PathVariable UUID orderId, @PathVariable String codePromo) {
        manageOrderUseCase.applyDiscount(new DiscountCommand(orderId), codePromo);
    }
}