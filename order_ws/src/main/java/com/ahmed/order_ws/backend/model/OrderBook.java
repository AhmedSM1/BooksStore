package com.ahmed.order_ws.backend.model;

import com.ahmed.common.ValueObjects.Stock;

public class OrderBook {
    private String bookId;
    private String orderId;
    private Stock amountRequested;
    private double unitPrice;

    public OrderBook(String bookId, String orderId, Stock amountRequested, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.amountRequested = amountRequested;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getAmountRequested() {
        return amountRequested;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
