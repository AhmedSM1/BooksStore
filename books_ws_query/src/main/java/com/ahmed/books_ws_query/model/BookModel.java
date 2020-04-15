package com.ahmed.books_ws_query.model;

import com.ahmed.common.books.BookStatus;

public class BookModel {

    private String bookId;
    private String title;
    private String description;
    private double price;
    private BookStatus status;

    public BookModel() {
    }

    public BookModel(String bookId, String title, String description, double price, BookStatus status) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}


