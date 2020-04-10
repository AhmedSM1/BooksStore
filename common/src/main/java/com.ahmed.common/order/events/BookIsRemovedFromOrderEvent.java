package com.ahmed.common.order.events;

import com.ahmed.common.ValueObjects.Stock;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String orderId;
    private String bookId;
    private Stock  amountToRemove;
    private double unitPrice;

    public BookIsRemovedFromOrderEvent(String orderId, String bookId, Stock amountToRemove, double unitPrice) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.amountToRemove = amountToRemove;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public Stock getAmountToRemove() {
        return amountToRemove;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
