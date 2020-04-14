package com.ahmed.common.order.events;

public class BookIsAddedToOrderEvent implements OrderEvent {
    private String bookId;
    private String bookTitle;
    private double unitPrice;

    public BookIsAddedToOrderEvent(String bookId, String bookTitle, double unitPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public BookIsAddedToOrderEvent() {
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
