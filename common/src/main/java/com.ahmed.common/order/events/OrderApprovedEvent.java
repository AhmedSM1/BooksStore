package com.ahmed.common.order.events;

import com.ahmed.common.ValueObjects.Stock;

public class OrderApprovedEvent implements OrderEvent {
    private String bookId;
    private String orderId;
    private Stock  booksRequested;
    private double unitPrice;

    public OrderApprovedEvent(String bookId, String orderId, Stock booksRequested, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.booksRequested = booksRequested;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getBooksRequested() {
        return booksRequested;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
