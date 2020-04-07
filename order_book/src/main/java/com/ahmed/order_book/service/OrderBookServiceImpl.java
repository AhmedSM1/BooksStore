package com.ahmed.order_book.service;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.order_book.config.OrderAndBookService;
import com.ahmed.order_book.domain.CreateOrderBookCommand;
import com.ahmed.order_book.domain.OrderBook;
import com.ahmed.order_book.domain.OrderBookCommand;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;

public class OrderBookServiceImpl implements OrderBookService {
    private final AggregateRepository<OrderBook, OrderBookCommand> orderBookRepository;
    OrderAndBookService orderAndBookService;

    public OrderBookServiceImpl(AggregateRepository<OrderBook, OrderBookCommand> orderBookRepository, OrderAndBookService orderAndBookService) {
        this.orderBookRepository = orderBookRepository;
        this.orderAndBookService = orderAndBookService;
    }

    @Override
    public EntityWithIdAndVersion<OrderBook> addToOrder(String orderId, String bookId, Stock requestedAmount) {
        orderAndBookService.verifyBooksBookId(bookId);
        orderAndBookService.verifyOrdersOrderId(orderId);
        return orderBookRepository.save(new CreateOrderBookCommand(bookId,orderId,requestedAmount));
    }

    @Override
    public EntityWithIdAndVersion<OrderBook> removeOrder(String orderId, String bookId, Stock subtractAmount) {
        orderAndBookService.verifyBooksBookId(bookId);
        orderAndBookService.verifyOrdersOrderId(orderId);
        return orderBookRepository.save(new CreateOrderBookCommand(bookId,orderId,subtractAmount));
    }
}
