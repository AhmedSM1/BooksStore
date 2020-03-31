package com.ahmed.order_ws.backend.controller;

import com.ahmed.common.books.Book;

public class OrderBookDTO {
    private Book book;
    private int quantity;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
