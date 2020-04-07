package com.ahmed.books_ws.model;

public class BookResponseModel {
    private String bookId;

    public BookResponseModel(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
