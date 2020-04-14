package com.ahmed.order_ws.commands;

public class RemoveBookFromOrderCommand implements OrderCommand {
    private String orderId;
    private String bookId;
    private double moneyToRemove;

    public RemoveBookFromOrderCommand(String orderId, String bookId, double moneyToRemove) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.moneyToRemove = moneyToRemove;
    }

    public RemoveBookFromOrderCommand() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public double getMoneyToRemove() {
        return moneyToRemove;
    }
}
