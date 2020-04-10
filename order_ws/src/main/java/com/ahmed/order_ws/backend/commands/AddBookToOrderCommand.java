package com.ahmed.order_ws.backend.commands;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.order_ws.backend.model.OrderBook;

public class AddBookToOrderCommand implements OrderCommand {
      private OrderBook orderBook;

    public AddBookToOrderCommand(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public OrderBook getOrderBook() {
        return orderBook;
    }
}
