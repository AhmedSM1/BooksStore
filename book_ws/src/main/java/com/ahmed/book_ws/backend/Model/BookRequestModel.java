package com.ahmed.book_ws.backend.Model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookRequestModel {
    //** responsible for submiting details from a client application(structure of this model might change with time */
    @NotNull(message = "Book title cannot be null")
    @Size(min = 2, message = "Book title must not be less than two characters")
    private String bookTitle;

    @NotNull(message = "Book description cannot be null")
    @Size(min = 2, message = "Book description must not be less than two characters")
    private String description;


    @NotNull(message = "Price cannot be null")
    @Min(value = 1)
    private double price;

    @NotNull(message = "items cannot be null")
    @Min(value = 1)
    private int availableItemCount;

    public BookRequestModel(String bookTitle, String description, double price, int availableItemCount) {
        this.bookTitle = bookTitle;
        this.description = description;
        this.price = price;
        this.availableItemCount = availableItemCount;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(int availableItemCount) {
        this.availableItemCount = availableItemCount;
    }
}
