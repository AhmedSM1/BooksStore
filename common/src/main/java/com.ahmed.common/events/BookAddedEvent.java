package com.ahmed.common.events;


import com.ahmed.common.books.BookInfo;


public class BookAddedEvent implements BookEvent {
    private  BookInfo info;

    public BookAddedEvent(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }
}
