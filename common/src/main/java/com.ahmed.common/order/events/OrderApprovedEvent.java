package com.ahmed.common.order.events;

public class OrderApprovedEvent implements OrderEvent {
    private String bookId;
    private String orderId;
    private int  booksRequested;
    private double unitPrice;

    public OrderApprovedEvent(String bookId, String orderId, int booksRequested, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.booksRequested = booksRequested;
        this.unitPrice = unitPrice;
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

    public int getBooksRequested() {
        return booksRequested;
    }

    public void setBooksRequested(int booksRequested) {
        this.booksRequested = booksRequested;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
