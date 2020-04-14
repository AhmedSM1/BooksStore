package com.ahmed.common.order.events;

public class OrderApprovedEvent implements OrderEvent {
    private String bookId;
    private String orderId;


    public OrderApprovedEvent(String bookId, String orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

    public OrderApprovedEvent() {
    }



    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }
}
