package com.ahmed.order_ws.model;

public class RemoveBookRequest {
    private String bookId;
    private String orderId;
    private double moneyToRemove;

    public RemoveBookRequest(String bookId, String orderId, double moneyToRemove) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.moneyToRemove = moneyToRemove;
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

    public double getMoneyToRemove() {
        return moneyToRemove;
    }

    public void setMoneyToRemove(double moneyToRemove) {
        this.moneyToRemove = moneyToRemove;
    }
}
