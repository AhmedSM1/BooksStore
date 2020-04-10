package com.ahmed.order_ws.backend.service;


import com.ahmed.order_ws.backend.Order;
import com.ahmed.order_ws.backend.model.OrderBook;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

@Validated
public interface OrderService{
    EntityWithIdAndVersion<Order> createOrder(String customerId);

    CompletableFuture<EntityWithIdAndVersion<Order>> orderBook(@NotNull(message = " must contain items") @Valid OrderBook orderBook);

    void update(@NotNull(message = "Order must contain books") @Valid Order order);

    CompletableFuture<EntityWithMetadata<Order>> findById(String orderId);
}