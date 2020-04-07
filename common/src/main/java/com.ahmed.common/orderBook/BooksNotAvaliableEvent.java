package com.ahmed.common.orderBook;

public class BooksNotAvaliableEvent implements OrderBookEvent {
    private String bookId;


    public BooksNotAvaliableEvent(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
