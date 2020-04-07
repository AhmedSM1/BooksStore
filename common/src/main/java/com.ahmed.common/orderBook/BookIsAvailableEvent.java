package com.ahmed.common.orderBook;

import com.ahmed.common.ValueObjects.Stock;

public class BookIsAvailableEvent implements OrderBookEvent{
    private String bookId;

    public BookIsAvailableEvent(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
