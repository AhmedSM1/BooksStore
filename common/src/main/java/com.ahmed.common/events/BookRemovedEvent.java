package com.ahmed.common.events;



public class BookRemovedEvent implements BookEvent {
    String bookId;

    public BookRemovedEvent() {
    }

    public BookRemovedEvent(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
