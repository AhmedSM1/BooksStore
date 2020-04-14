package com.ahmed.common.order.events;

public class BookIsAddedToOrderEvent implements OrderEvent {
    private String bookId;
    private String orderId;

    public BookIsAddedToOrderEvent(String bookId, String orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

    public BookIsAddedToOrderEvent() {
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }
}
