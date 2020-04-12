package com.ahmed.order_ws.commands;

public class RemoveBookFromOrderCommand implements OrderCommand {
    private String orderId;
    private String bookId;
    private int amountToRemove;
    private double moneyToRemove;

    public RemoveBookFromOrderCommand(String orderId, String bookId, int amountToRemove, double moneyToRemove) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.amountToRemove = amountToRemove;
        this.moneyToRemove = moneyToRemove;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getAmountToRemove() {
        return amountToRemove;
    }

    public void setAmountToRemove(int amountToRemove) {
        this.amountToRemove = amountToRemove;
    }

    public double getMoneyToRemove() {
        return moneyToRemove;
    }

    public void setMoneyToRemove(double moneyToRemove) {
        this.moneyToRemove = moneyToRemove;
    }
}
