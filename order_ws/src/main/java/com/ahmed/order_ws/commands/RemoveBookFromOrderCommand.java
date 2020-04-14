package com.ahmed.order_ws.commands;

public class RemoveBookFromOrderCommand implements OrderCommand {
      private String bookId;
      private String orderId;

    public RemoveBookFromOrderCommand(String bookId, String orderId) {
        this.bookId = bookId;
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
