package com.ahmed.order_ws.commands;

public class AddBookToOrderCommand implements OrderCommand {
      private String bookId;
      private String orderId;
      private double unitPrice;
      private int bookAmount;

    public AddBookToOrderCommand(String bookId, String orderId, double unitPrice, int bookAmount) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
        this.bookAmount = bookAmount;
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

    public int getBookAmount() {
        return bookAmount;
    }
}
