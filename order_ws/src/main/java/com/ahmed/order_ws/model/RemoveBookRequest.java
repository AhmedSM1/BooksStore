package com.ahmed.order_ws.model;

public class RemoveBookRequest {
    private String bookId;

    public RemoveBookRequest(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
