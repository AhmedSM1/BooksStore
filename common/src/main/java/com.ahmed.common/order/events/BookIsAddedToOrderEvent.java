package com.ahmed.common.order.events;

public class BookIsAddedToOrderEvent implements OrderEvent {
    private String bookId;
    private String orderId;
    private double unitPrice;
    private int bookAmount;

    public BookIsAddedToOrderEvent(String bookId, String orderId, double unitPrice, int bookAmount) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
        this.bookAmount = bookAmount;
    }

    public BookIsAddedToOrderEvent() {
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
