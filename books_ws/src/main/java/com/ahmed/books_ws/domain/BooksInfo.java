package com.ahmed.books_ws.domain;

public class BooksInfo {
    private String title;
    private String description;
    private double price;
    private int availableItemCount;

    public BooksInfo(String title, String description, double price, int availableItemCount) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableItemCount() {
        return availableItemCount;
    }
}
