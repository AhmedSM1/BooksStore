package com.ahmed.common.books;

public class BookInfo {
    private String title;
    private String description;
    private double price;


    public BookInfo(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;

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
}
