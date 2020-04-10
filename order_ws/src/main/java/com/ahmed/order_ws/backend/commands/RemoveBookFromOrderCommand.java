package com.ahmed.order_ws.backend.commands;

import com.ahmed.common.ValueObjects.Stock;

public class RemoveBookFromOrderCommand implements OrderCommand {
    private String orderId;
    private String bookId;
    private Stock amountToRemove;
    private double moneyToRemove;

    public RemoveBookFromOrderCommand(String orderId, String bookId, Stock amountToRemove, double moneyToRemove) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.amountToRemove = amountToRemove;
        this.moneyToRemove = moneyToRemove;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public Stock getAmountToRemove() {
        return amountToRemove;
    }

    public double getMoneyToRemove() {
        return moneyToRemove;
    }
}
