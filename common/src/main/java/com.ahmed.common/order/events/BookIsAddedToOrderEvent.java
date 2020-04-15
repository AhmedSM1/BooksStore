package com.ahmed.common.order.events;

public class BookIsAddedToOrderEvent implements OrderEvent {
    private String bookId;
    private String bookTitle;
    private String orderId;
    private double unitPrice;

    public BookIsAddedToOrderEvent(String bookId, String bookTitle, String orderId, double unitPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.orderId = orderId;
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

    public String getOrderId() {
        return orderId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
