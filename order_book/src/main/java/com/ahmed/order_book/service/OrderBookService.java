package com.ahmed.order_book.service;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.order_book.domain.OrderBook;
import io.eventuate.EntityWithIdAndVersion;

public interface OrderBookService {
    EntityWithIdAndVersion<OrderBook> addToOrder(String orderId, String bookId, Stock requestedAmount);
    EntityWithIdAndVersion<OrderBook> removeOrder(String orderId, String bookId, Stock subtractAmount);

}
