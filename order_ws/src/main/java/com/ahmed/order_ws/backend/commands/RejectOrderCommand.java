package com.ahmed.order_ws.backend.commands;


public class RejectOrderCommand implements OrderCommand {
    private String  orderId;
    private String  bookId;

    public RejectOrderCommand(String orderId, String bookId) {
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
