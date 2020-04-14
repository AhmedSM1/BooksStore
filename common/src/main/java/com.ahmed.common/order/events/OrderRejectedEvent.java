package com.ahmed.common.order.events;

public class OrderRejectedEvent implements OrderEvent{
    private String bookId;
    private String orderId;

    public OrderRejectedEvent(String bookId, String orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

    public OrderRejectedEvent() {
    }



    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }
}
