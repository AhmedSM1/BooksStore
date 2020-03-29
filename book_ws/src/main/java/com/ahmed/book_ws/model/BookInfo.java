package com.ahmed.book_ws.model;

public class BookInfo {
    private  String bookTitle;
    private  String description;
    private double price;
    private BookCategory bookcatagory;
    private int availableItemCount;

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

    public BookCategory getBookcatagory() {
        return bookcatagory;
    }

    public void setBookcatagory(BookCategory bookcatagory) {
        this.bookcatagory = bookcatagory;
    }

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(int availableItemCount) {
        this.availableItemCount = availableItemCount;
    }
}
