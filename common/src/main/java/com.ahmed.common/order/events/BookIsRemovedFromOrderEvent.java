package com.ahmed.common.order.events;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String bookId;
    private String orderId;
    private String bookTitle;
    private double unitPrice;

    public BookIsRemovedFromOrderEvent(String bookId, String orderId, String bookTitle, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.bookTitle = bookTitle;
        this.unitPrice = unitPrice;
    }

    public BookIsRemovedFromOrderEvent() {
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
