package com.ahmed.order_ws.backend.service;


import com.ahmed.common.order.Order;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService{
    EntityWithIdAndVersion<Order> create(@NotNull(message = "Order must contain books") @Valid Order order);

    void update(@NotNull(message = "Order must contain books") @Valid Order order);

    Iterable<Order> getAllOrders();
}