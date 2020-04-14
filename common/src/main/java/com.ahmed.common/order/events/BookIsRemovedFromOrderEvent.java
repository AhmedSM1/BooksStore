package com.ahmed.common.order.events;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String orderId;
    private String bookId;
    private double unitPrice;

    public BookIsRemovedFromOrderEvent(String orderId, String bookId, double unitPrice) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.unitPrice = unitPrice;
    }

    public BookIsRemovedFromOrderEvent() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
