package com.ahmed.common.books;

public class BookRemovedEvent implements BookEvent {
    private String bookId;
    private BookStatus status;

    public BookRemovedEvent(String bookId, BookStatus status) {
        this.bookId = bookId;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public BookStatus getStatus() {
        return status;
    }
}
