package com.ahmed.order_ws.commands;

public class ApproveOrderCommand implements OrderCommand {
    private String bookId;
    private String orderId;


    public ApproveOrderCommand(String bookId, String orderId) {
        this.bookId = bookId;
        this.orderId = orderId;

    }

    public ApproveOrderCommand() {
    }



    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }
}
