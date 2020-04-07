package com.ahmed.books_ws.model;

import com.ahmed.common.ValueObjects.Stock;

public class BookInfo {
    private String title;
    private String description;
    private double price;
    private Stock availableItemCount;

    public BookInfo(String title, String description, double price, Stock availableItemCount) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(Stock availableItemCount) {
        this.availableItemCount = availableItemCount;
    }
}
