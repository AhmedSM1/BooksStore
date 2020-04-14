package com.ahmed.order_ws.commands;

public class AddBookToOrderCommand implements OrderCommand {
      private String bookId;
      private String bookTitle;
      private double unitPrice;

    public AddBookToOrderCommand(String bookId, String bookTitle, double unitPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
