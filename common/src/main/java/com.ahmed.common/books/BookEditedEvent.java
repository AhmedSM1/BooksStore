package com.ahmed.common.books;


public class BookEditedEvent implements BookEvent {
    private BookInfo info;
    private BookStatus status;

    public BookEditedEvent(BookInfo info, BookStatus status) {
        this.info = info;
        this.status = status;
    }

    public BookEditedEvent() {
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
