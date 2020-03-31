package com.ahmed.common.books;


public class BookInfo {
    private String bookTitle;

    private String description;

    private double price;

    private int availableItemCount;

    public BookInfo(String bookTitle, String description, double price, int availableItemCount) {
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
