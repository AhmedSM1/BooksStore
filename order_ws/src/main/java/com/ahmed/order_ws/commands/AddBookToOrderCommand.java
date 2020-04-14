package com.ahmed.order_ws.commands;

public class AddBookToOrderCommand implements OrderCommand {
      private String bookId;
      private String orderId;
      private double unitPrice;


    public AddBookToOrderCommand(String bookId, String orderId, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
    }

    public AddBookToOrderCommand() {
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


}
