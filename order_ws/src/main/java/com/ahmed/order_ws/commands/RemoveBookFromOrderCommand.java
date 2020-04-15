package com.ahmed.order_ws.commands;

public class RemoveBookFromOrderCommand implements OrderCommand {
      private String bookId;
      private String orderId;
      private String bootTitle;
      private double unitPrice;

    public RemoveBookFromOrderCommand(String bookId, String orderId, String bootTitle, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.bootTitle = bootTitle;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBootTitle() {
        return bootTitle;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
