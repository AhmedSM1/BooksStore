package com.ahmed.order_ws.model;

public class AddBookRequest {
    private String bookId;

    public AddBookRequest(String bookId) {
        this.bookId = bookId;
    }

    public AddBookRequest() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
