package com.ahmed.order_ws.backend.service;

import com.ahmed.order_ws.backend.model.OrderBook;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderBookService {
    OrderBook create(@NotNull(message = "Cart must contain items") @Valid OrderBook orderBook);
}
