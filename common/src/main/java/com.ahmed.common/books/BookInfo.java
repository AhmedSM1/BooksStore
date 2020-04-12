package com.ahmed.common.books;

public class BookInfo {
    private String title;
    private String description;
    private double price;
    private int availableItemCount;


    public BookInfo(String title, String description, double price, int availableItemCount) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;

    }

    public BookInfo() {
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
