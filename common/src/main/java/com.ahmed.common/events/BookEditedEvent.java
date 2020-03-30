package com.ahmed.common.events;


import com.ahmed.common.BookInfo;

public class BookEditedEvent implements BookEvent {
   private BookInfo info;

    public BookEditedEvent(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }
}
