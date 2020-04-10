package com.ahmed.order_ws.backend.model;

import com.ahmed.common.ValueObjects.Stock;

public class BookRes {
    private String bookId;
    private String bookTitle;
    private Stock  stock;

    public BookRes(String bookId, String bookTitle, Stock stock) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.stock = stock;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Stock getStock() {
        return stock;
    }
}
