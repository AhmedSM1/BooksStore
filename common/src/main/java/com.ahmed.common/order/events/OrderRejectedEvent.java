package com.ahmed.common.order.events;

public class OrderRejectedEvent implements OrderEvent{
    private String orderId;
    private String bookId;

    public OrderRejectedEvent(String orderId, String bookId) {
        this.orderId = orderId;
        this.bookId = bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }
}
