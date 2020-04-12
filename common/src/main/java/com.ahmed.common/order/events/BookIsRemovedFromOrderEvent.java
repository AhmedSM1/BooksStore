package com.ahmed.common.order.events;

public class BookIsRemovedFromOrderEvent implements OrderEvent {
    private String orderId;
    private String bookId;
    private int  amountToRemove;
    private double unitPrice;

    public BookIsRemovedFromOrderEvent(String orderId, String bookId, int amountToRemove, double unitPrice) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.amountToRemove = amountToRemove;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public int getAmountToRemove() {
        return amountToRemove;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
