package com.ahmed.common.books;

import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.books.BookStatus;

public class BookInfo {
    private String title;
    private String description;
    private double price;
    private int availableItemCount;
    private BookStatus status;

    public BookInfo(String title, String description, double price, int availableItemCount, BookStatus status) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
        this.status = status;
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

    public BookStatus getStatus() {
        return status;
    }
}
