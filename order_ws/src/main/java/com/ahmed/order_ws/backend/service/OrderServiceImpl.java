package com.ahmed.order_ws.backend.service;


import com.ahmed.order_ws.backend.Order;
import com.ahmed.order_ws.backend.commands.AddBookToOrderCommand;
import com.ahmed.order_ws.backend.commands.CreateOrderCommand;
import com.ahmed.order_ws.backend.commands.OrderCommand;
import com.ahmed.order_ws.backend.model.OrderBook;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import io.eventuate.sync.AggregateRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

public class OrderServiceImpl implements OrderService {

    private final AggregateRepository<Order, OrderCommand> orderRepository;

    public OrderServiceImpl(AggregateRepository<Order, OrderCommand> orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public EntityWithIdAndVersion<Order> createOrder(String customerId) {
        return   orderRepository.save(new CreateOrderCommand(customerId));

    }

    @Override
    public CreateOrderResponse orderBook(@NotNull(message = "order must contain books") @Valid OrderBook orderBook) {
        orderRepository.save(new AddBookToOrderCommand(orderBook));
        return new CreateOrderResponse(orderBook.getBookId(),orderBook.getOrderId());
    }

    @Override
    public void update(@NotNull(message = "Order must contain books") @Valid Order order) {

    }

    @Override
    public EntityWithMetadata<Order> findById(String orderId) {
        return orderRepository.find(orderId);
    }


}
