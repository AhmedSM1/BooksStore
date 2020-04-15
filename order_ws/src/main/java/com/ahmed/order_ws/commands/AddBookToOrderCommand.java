package com.ahmed.order_ws.commands;

public class AddBookToOrderCommand implements OrderCommand {
      private String bookId;
      private String orderId;
      private String bookTitle;
      private double unitPrice;

    public AddBookToOrderCommand(String bookId, String orderId, String bookTitle, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
