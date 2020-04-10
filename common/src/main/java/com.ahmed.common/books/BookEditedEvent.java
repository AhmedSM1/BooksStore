package com.ahmed.common.books;


import com.ahmed.common.ValueObjects.Stock;
import com.ahmed.common.books.BookEvent;

public class BookEditedEvent implements BookEvent {
    private BookInfo info;
    private BookStatus status;

    public BookEditedEvent(BookInfo info, BookStatus status) {
        this.info = info;
        this.status = status;
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
