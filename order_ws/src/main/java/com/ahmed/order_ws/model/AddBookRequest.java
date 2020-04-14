package com.ahmed.order_ws.model;

public class AddBookRequest {
    private String bookId;
    private String orderId;
    private double unitPrice;

    public AddBookRequest(String bookId, String orderId, double unitPrice) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
    }

    public AddBookRequest() {
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
