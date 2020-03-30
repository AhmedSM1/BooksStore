package com.ahmed.order_ws.backend.service;

import com.ahmed.order_ws.backend.model.Order;
import com.ahmed.order_ws.backend.model.OrderItemRepo;
import com.ahmed.order_ws.backend.model.OrderRepo;

import io.eventuate.EntityWithIdAndVersion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo repo;

    @Autowired
    OrderItemRepo itemRepo;


    @Override
    public EntityWithIdAndVersion<Order> create(@NotNull(message = "Order must contain books") @Valid Order order) {
        return null;
    }

    @Override
    public void update(@NotNull(message = "Order must contain books") @Valid Order order) {

    }

    @Override
    public Iterable<Order> getAllOrders() {
        return null;
    }
}
