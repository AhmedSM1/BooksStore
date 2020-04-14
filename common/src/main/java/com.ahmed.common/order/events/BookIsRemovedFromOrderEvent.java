package com.ahmed.common.order.events;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String orderId;
    private String bookId;

    public BookIsRemovedFromOrderEvent(String orderId, String bookId) {
        this.orderId = orderId;
        this.bookId = bookId;
    }

    public BookIsRemovedFromOrderEvent() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }
}
