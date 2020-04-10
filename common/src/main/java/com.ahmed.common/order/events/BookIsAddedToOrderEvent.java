package com.ahmed.common.order.events;

import com.ahmed.common.ValueObjects.Stock;

public class BookIsAddedToOrderEvent implements OrderEvent {
    private String bookId;
    private String orderId;
    private Stock amountAsked;
    private double unitPrice;

    public BookIsAddedToOrderEvent(String bookId, String orderId, Stock amountAsked, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.amountAsked = amountAsked;
        this.unitPrice = unitPrice;
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

    public double getUnitPrice() {
        return unitPrice;
    }
}
