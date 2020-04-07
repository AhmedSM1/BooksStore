package com.ahmed.order_book.domain;

import com.ahmed.common.ValueObjects.Stock;

public class CreateOrderBookCommand implements OrderBookCommand {
    private final String bookId;
    private final String orderId;
    private final Stock amountAsked;

    public CreateOrderBookCommand(String bookId, String orderId, Stock amountAsked) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.amountAsked = amountAsked;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getAmountAsked() {
        return amountAsked;
    }
}
