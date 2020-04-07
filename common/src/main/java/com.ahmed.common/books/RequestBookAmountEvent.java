package com.ahmed.common.books;

import com.ahmed.common.ValueObjects.Stock;

public class RequestBookAmountEvent implements BookEvent {
    private String bookId;
    private String orderId;
    private Stock bookAmount;

    public RequestBookAmountEvent(String bookId, String orderId, Stock bookAmount) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.bookAmount = bookAmount;
    }

    public String getBookId() {
        return bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Stock getBookAmount() {
        return bookAmount;
    }
}
