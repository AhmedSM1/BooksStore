package com.ahmed.common.books;


import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.books.BookEvent;

import java.util.Objects;

public class BookCreatedEvent implements BookEvent {

    private String title;
    private String description;
    private double price;
    private Stock availableItemCount;

    public BookCreatedEvent(String title, String description, double price, Stock availableItemCount) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCreatedEvent that = (BookCreatedEvent) o;
        return Double.compare(that.price, price) == 0 &&
                availableItemCount == that.availableItemCount &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price, availableItemCount);
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

    public Stock getAvailableItemCount() {
        return availableItemCount;
    }
}
