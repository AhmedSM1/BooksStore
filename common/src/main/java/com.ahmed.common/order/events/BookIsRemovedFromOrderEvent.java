package com.ahmed.common.order.events;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String bookId;
    private String bookTitle;
    private double unitPrice;

    public BookIsRemovedFromOrderEvent(String bookId, String bookTitle, double unitPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public BookIsRemovedFromOrderEvent() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
