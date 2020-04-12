package com.ahmed.order_ws.model;

public class Books {
    private String bookId;
    private String title;
    private int amount;
    private double price;

    public Books(String bookId, String title, int amount, double price) {
        this.bookId = bookId;
        this.title = title;
        this.amount = amount;
        this.price = price;
    }
}
