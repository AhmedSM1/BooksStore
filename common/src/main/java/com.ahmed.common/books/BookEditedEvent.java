package com.ahmed.common.books;


import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.books.BookEvent;

public class BookEditedEvent implements BookEvent {

    private String title;
    private Stock stock;
    private double price;
    private String description;

    public BookEditedEvent(String title, Stock stock, double price, String description) {
        this.title = title;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Stock getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
